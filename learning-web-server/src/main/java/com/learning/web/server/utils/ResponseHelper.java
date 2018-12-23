package com.learning.web.server.utils;

public class ResponseHelper {
	// The html template of response
	private static final String HTML = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "Content-Length: %d\r\n"
			+ "\r\n" + "%s";

	public static String fmtResponse(String respStr) {
		respStr = "<h1>" + respStr + "</h1>";
		return String.format(HTML, respStr.length(), respStr);
	}
}
