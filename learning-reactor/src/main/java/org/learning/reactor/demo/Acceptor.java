package org.learning.reactor.demo;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {
	private Reactor reactor;

	public Acceptor(Reactor reactor) {
		this.reactor = reactor;
	}

	@Override
	public void run() {
		try {
			SocketChannel socketChannel = this.reactor.serverSocketChannel.accept();
			if (socketChannel != null) {
				new SocketReadHandler(this.reactor.selector, socketChannel).run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
