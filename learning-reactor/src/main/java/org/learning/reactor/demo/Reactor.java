package org.learning.reactor.demo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {
	public final Selector selector;
	public final ServerSocketChannel serverSocketChannel;

	public Reactor(int port) throws IOException {
		this.selector = Selector.open();
		this.serverSocketChannel = ServerSocketChannel.open();
		this.serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), 9999));
		this.serverSocketChannel.configureBlocking(false);

		this.serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT).attach(new Acceptor(this));
	}

	@Override
	public void run() {
		try {
			while (selector.select() > 0) {
				Set<SelectionKey> selectkeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectkeys.iterator();
				while(iterator.hasNext()) {
					dispatch(iterator.next());
					selectkeys.clear();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void dispatch(SelectionKey selectKey) {
		Runnable runnable = (Acceptor)selectKey.attachment();
		if(runnable != null) {
			runnable.run();
		}
	}
}
