package com.learning.protocol.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PostHttpClient {
	private int connectTimeout = 2000; // 链接超时时间
	private int readTimeout = 5000; // 读超时时间
	private String host;
	private int port = 80;
	private String resource = "/";
	private String reqLine;
	private String body;
	private Map<String, String> headers = new HashMap<String, String>();

	public PostHttpClient(String uri) {
		initRequestHeader();
		parseRequestLine(uri);
	}

	public PostHttpClient(String uri, int connectTimeout, int readTimeOut) {
		initRequestHeader();
		parseRequestLine(uri);
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeOut;
	}

	/**
	 * 解析出IP地址、端口以及请求资源
	 * 
	 * @param uri
	 */
	private void parseRequestLine(String uri) {
		String url = uri;
		if (url == null)
			throw new NullPointerException("uri can not be null");
		if (!url.startsWith("http"))
			url = "http://" + uri;
		String[] parts = url.split("//");
		if (parts.length >= 2) {
			String mainPart = parts[1];
			int ipFlag = mainPart.indexOf("/");
			if (ipFlag != -1) {
				String ipPart = mainPart.substring(0, ipFlag);
				resource = mainPart.substring(ipFlag);
				String[] ipParts = ipPart.split(":");
				if (ipParts.length > 1) {
					host = ipParts[0];
					String portStr = ipParts[1];
					if (portStr != null && portStr.length() > 0)
						port = Integer.parseInt(portStr);
				} else {
					host = ipPart;
				}
			} else {
				host = mainPart;
			}
		} else {
			throw new IllegalArgumentException("非法的uri");
		}
		String hostVal = host;
		if (port != 80)
			hostVal += ":" + port;
		headers.put("Host", hostVal);

		reqLine = "POST " + resource + " HTTP/1.1\r\n";
	}

	private void initRequestHeader() {
		headers.put("Connection", "keep-alive");
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("User-Agent", "Java client");
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		headers.put("Accept-Encoding", "gzip");
		headers.put("Accept-Language", "zh-CN,zh");
		headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	}

	public void setHeader(String key, String value) {
		headers.put(key, value);
	}

	private void concatParam(Map<String, String> parameters) {
		if (parameters == null || parameters.isEmpty())
			return;

		String params = "";
		Iterator<String> itor = parameters.keySet().iterator();
		while (itor.hasNext()) {
			String key = itor.next();
			String val = parameters.get(key);
			params += ("&" + key + "=" + val);
		}
		body = params.replaceFirst("&", "");
	}

	public RespMsg req(Map<String, String> parameters) {
		concatParam(parameters);
		int contentLen = 0;
		if (body != null)
			contentLen = body.getBytes().length;
		this.headers.put("Content-Length", String.valueOf(contentLen));
		RespMsg msg = null;
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			SocketAddress endpoint = new InetSocketAddress(host, port);
			socket = new Socket();
			socket.connect(endpoint, connectTimeout);
			socket.setSoTimeout(readTimeout);

			out = socket.getOutputStream();
			write(out);

			in = socket.getInputStream();
			msg = read(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if (socket != null)
					socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return msg;
	}

	private void write(OutputStream out) throws IOException {
		String reqBody = reqLine;
		Iterator<String> itor = headers.keySet().iterator();
		while (itor.hasNext()) {
			String key = itor.next();
			String val = headers.get(key);
			String header = key + ":" + val + "\r\n";
			reqBody += header;
		}

		reqBody += "\r\n";
		reqBody += body;
		out.write(reqBody.getBytes("UTF-8"));
	}

	private RespMsg read(InputStream in) throws IOException {
		RespMsg respMsg = new RespMsg();
		byte[] heads = HttpStreamReader.readHeaders(in);
		String headStr = new String(heads);
		respMsg.setRespBody(headStr);
		return respMsg;
	}

	private static String readChunked(InputStream in) throws IOException {
		String content = "";
		String lenStr = "0";
		while (!(lenStr = new String(HttpStreamReader.readLine(in))).equals("0")) {
			int len = Integer.valueOf(lenStr.toUpperCase(), 16);// 长度16进制表示
			byte[] cnt = new byte[len];
			in.read(cnt);
			content += new String(cnt, "UTF-8");
			in.skip(2);
		}

		return content;
	}

	public static void post() {
		String uri = "http://localhost:8080/Newer/server.action";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "123");
		params.put("name", "张三");

		PostHttpClient post = new PostHttpClient(uri);
		RespMsg msg = post.req(params);

		String respCodeMsg = msg.getRespCodeMsg();
		String respBody = msg.getRespBody();

		System.out.println(respCodeMsg);
		System.out.println(respBody);
	}

	public static void main(String[] args) {
		post();
	}
}
