package org.learning.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel = null;
		Scanner scanner = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));

			if (socketChannel.finishConnect()) {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				scanner = new Scanner(System.in);
				String line = "";
				while ((line = scanner.nextLine()) != null) {
					sendMessage(socketChannel, buffer, line);
					if("exit".equalsIgnoreCase(line)) {
						break;
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Client stop!!");
		}
	}

	private static void sendMessage(SocketChannel socketChannel, ByteBuffer buffer, String message)
			throws InterruptedException, IOException {
		buffer.clear();
		buffer.put(message.getBytes());
		buffer.flip();
		while (buffer.hasRemaining()) {
			socketChannel.write(buffer);
		}
		buffer.compact();
	}
}
