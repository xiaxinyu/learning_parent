package com.learning.web.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.web.server.exception.NotFoundServletException;
import com.learning.web.server.utils.RequestHelper;
import com.learning.web.server.utils.ResponseHelper;

public class SocketHandler extends Thread {
	private final static Logger logger = LoggerFactory.getLogger(SocketHandler.class);

	// client can use http get uri to close server, eg: http://localhost:8080/stop
	private static final String STOP_URL = "/stop";
	// if client stop server, the string of response
	private static final String CLOSE_RESP_STR = "Server Close";
	private Socket client;
	private Map<String, Servlet> servletMapping;

	public SocketHandler(Socket client, Map<String, Servlet> servletMapping) {
		this.client = client;
		this.servletMapping = servletMapping;
	}

	@Override
	public void run() {
		logger.info("Start-New connection：" + client.getInetAddress() + ":" + client.getPort());
		process(client);
	}

	private void process(Socket client) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = client.getInputStream();
			os = client.getOutputStream();

			// Read a complete arrival socket stream with bio but without block
			Request request = new Request(is);
			logger.info(request.toString());

			Response response = new Response(os);
			Servlet servlet = servletMapping.get(request.getUrl());
			if (null != servlet) {
				servlet.service(request, response);
			} else {
				logger.warn("Can't found {}", request.getUrl());
				response.setStatus(HttpStatus.S_404);
				response.write(HttpStatusText.of(HttpStatus.S_404).getText());
			}

			// String respStr = RequestHelper.parse(request.getHttpProtocol());
			// handle outputStream
			/*
			 * if (WebServer.STOP = STOP_URL.equalsIgnoreCase(respStr)) { respStr =
			 * CLOSE_RESP_STR; logger.info("Client {} require server to stop.",
			 * client.getInetAddress()); }
			 */
			os.flush();
		} catch (Exception e) {
			logger.error("Process client request has error.", e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				logger.error("Process client request has error.", e);
			}
		}
	}
}