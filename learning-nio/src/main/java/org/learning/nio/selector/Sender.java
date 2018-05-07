package org.learning.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Sender {
	public static void main(String[] args) throws Exception {

		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));

			if (socketChannel.finishConnect()) {
				sendMessage(socketChannel, "I'm the information from client");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void sendMessage(SocketChannel socketChannel, String message)
			throws InterruptedException, IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		TimeUnit.SECONDS.sleep(1);
		String info = message;
		buffer.clear();
		buffer.put(info.getBytes());
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.println(buffer);
			socketChannel.write(buffer);
		}
	}
}
