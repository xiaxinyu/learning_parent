package com.learning.web.server.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple http server using bio to read a socket stream<br>
 * and response the uri in http request line to client, <br>
 * that is uri after method blank and before the blank of protocol/version<br>
 * if the uri is "/stop", server close<br>
 * just test a method to read a complete arrival socket stream with a very small
 * buffer<br>
 * so the buffer should be used repeatedly to join the hold arrival message<br>
 * the key point is BufferedRead.ready() function which tell the next read() is
 * guaranteed not to block for input<br>
 * but the ready() return false do not guarantee the next read() is 100%
 * block<br>
 * 
 * Created by summer.xia on 2018.12.19
 *
 */
public class WebServer {
	private final static Logger logger = LoggerFactory.getLogger(WebServer.class);
	public static final int PORT = 8080;
	public static final int BACK_LOG = 50;
	public static volatile boolean STOP = false;
	private Map<String, Servlet> servletMapping = new ConcurrentHashMap<>();
	private Properties webXML = new Properties();

	public static void main(String[] args) {
		new WebServer().start();
	}

	private void init() {
		try {
			String basePath = this.getClass().getResource("/").getPath();
			InputStream inputStream = new FileInputStream(basePath + "web.properties");
			webXML.load(inputStream);

			for (Object k : webXML.keySet()) {
				String key = k.toString();
				if (key.endsWith(".url")) {
					String servletName = key.replaceAll("\\.url$", "") + ".className";
					String url = webXML.getProperty(key);
					String className = webXML.getProperty(servletName);

					Servlet servlet = (Servlet) Class.forName(className).newInstance();
					servletMapping.put(url, servlet);
				}
			}
		} catch (Exception e) {
			logger.error("Startring server has error", e);
		}
	}

	public void start() {
		init();

		ServerSocket server = null;
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress(PORT), BACK_LOG);
			logger.info("Start server, listen port {}", PORT);
			while (!STOP) {
				while (true) {
					new SocketHandler(server.accept(), servletMapping).start();
				}
			}
			server.close();
			System.exit(1);
		} catch (IOException e) {
			logger.error("Startring server has error", e);
			System.exit(1);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					logger.error("Startring server has error", e);
				}
			}
		}
	}
}