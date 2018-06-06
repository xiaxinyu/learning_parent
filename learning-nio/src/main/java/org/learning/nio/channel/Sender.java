package org.learning.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Sender extends Component {
	private SocketChannel socketChannel;

	public Sender(SocketChannel socketChannel) {
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
		/*buffer.clear();
		buffer.put(message.getBytes());
		buffer.flip();
		while (buffer.hasRemaining()) {
			this.socketChannel.write(buffer);
		}
		buffer.compact();*/
		this.socketChannel.write(ByteBuffer.wrap(message.getBytes()));
	}
}