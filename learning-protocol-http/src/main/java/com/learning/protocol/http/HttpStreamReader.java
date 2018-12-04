package com.learning.protocol.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpStreamReader {
	public static byte[] readHeaders(InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len = in.read(bytes)) != -1) {
			baos.write(bytes, 0, len);
		}
		return baos.toByteArray();
	}

	public static String readLine(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}
		br.close();
		return buffer.toString();
	}
}
