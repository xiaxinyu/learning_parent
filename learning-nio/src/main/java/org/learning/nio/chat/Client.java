package org.learning.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
	public void init() {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));
			if (socketChannel.finishConnect()) {
				new ClientListener(socketChannel).start();
				new ClientSender(socketChannel).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new Client().init();
	}
}

class ClientListener extends Thread {
	private SocketChannel socketChannel;

	public ClientListener(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		try {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			while (socketChannel.read(buf) != -1) {
				buf.flip();
				String message = "";
				while (buf.hasRemaining()) {
					message += (char) buf.get();
				}
				if (!"".equals(message)) {
					System.out.println(message);
					buf.clear();
					if ("exit".equals(message)) {
						break;
					}
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (this.socketChannel != null) {
				try {
					this.socketChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ClientSender extends Thread {
	private SocketChannel socketChannel;

	public ClientSender(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Scanner scanner = new Scanner(System.in);
		try {
			String line = "";
			while ((line = scanner.nextLine()) != null) {
				sendMessage(socketChannel, buffer, line);
				if ("exit".equalsIgnoreCase(line)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private void sendMessage(SocketChannel socketChannel, ByteBuffer buffer, String message) throws IOException {
		buffer.clear();
		buffer.put(message.getBytes());
		buffer.flip();
		while (buffer.hasRemaining()) {
			this.socketChannel.write(buffer);
		}
		buffer.compact();
	}
}
