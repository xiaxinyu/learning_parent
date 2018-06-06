package org.learning.nio.selector;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ServerSender extends Thread {
	private Selector selector = null;

	public ServerSender(Selector selector) {
		this.selector = selector;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			String line = "";
			while ((line = scanner.nextLine()) != null) {
				for (SelectionKey sk : this.selector.selectedKeys()) {
					this.selector.selectedKeys().remove(sk);
					if (sk.isAcceptable()) {
						SocketChannel socketChannel = (SocketChannel) sk.channel();
						socketChannel.write(ByteBuffer.wrap(line.getBytes()));
					}
				}
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
}