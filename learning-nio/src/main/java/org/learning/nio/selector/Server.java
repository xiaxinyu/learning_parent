package org.learning.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
	private Selector selector = null;

	public void init() throws IOException {
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress("127.0.0.1", 30000));
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);

		while (selector.select() > 0) {
			for (SelectionKey sk : selector.selectedKeys()) {
				selector.selectedKeys().remove(sk);

				if (sk.isAcceptable()) {
					doAccept(server);
				}

				if (sk.isReadable()) {
					doRead(sk);
				}
			}
		}
	}

	private void doAccept(ServerSocketChannel server) throws IOException {
		SocketChannel sc = server.accept();
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
	}

	private void doRead(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		new Listener(socketChannel, Type.SERVER).start();;
	}

	public static void main(String[] args) throws IOException {
		new Server().init();
	}
}
