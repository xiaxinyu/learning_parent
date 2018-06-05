package org.learning.nio.multi.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class WinterClient {
	private final static int BUF_SIZE = 10240;
	private final static String host = "localhost";
	private final static int port = 9000;
	private Selector selector;

	public void init() {
		try {
			this.selector = Selector.open();
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress(host, port));
			socketChannel.register(this.selector, SelectionKey.OP_CONNECT);

			while (true) {
				this.selector.select();
				Set<SelectionKey> set = this.selector.selectedKeys();
				Iterator<SelectionKey> iterator = set.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();

					try {
						if (key.isConnectable()) {
							doConnect(key);
						} else if (key.isReadable()) {
							doRead(key);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doConnect(SelectionKey key) throws Exception {
		try {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			if (socketChannel.isConnectionPending()) {
				socketChannel.finishConnect();
			}
			socketChannel.configureBlocking(false);

			String info = "Hello,I am winter!";
			ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
			byteBuffer.clear();
			byteBuffer.put(info.getBytes());
			byteBuffer.flip();

			socketChannel.write(byteBuffer);
			socketChannel.close();
		} catch (IOException e) {
			throw new Exception("doConnect has error.", e);
		}
	}

	private void doRead(SelectionKey key) throws Exception {
		try {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
			socketChannel.read(byteBuffer);
			byte[] data = byteBuffer.array();
			String msg = new String(data).trim();
			System.out.println("Server say:" + msg);
			socketChannel.close();
			key.selector().close();
		} catch (IOException e) {
			throw new Exception("doRead has error.", e);
		}
	}

	public static void main(String[] args) {
		new WinterClient().init();
	}
}
