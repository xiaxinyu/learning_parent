package org.learning.nio.multi.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
	private final static int BUF_SIZE = 10240;
	private final static int port = 9000;
	private Selector selector;

	public void init() {
		try {
			selector = Selector.open();

			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			channel.socket().bind(new InetSocketAddress(port));
			channel.register(selector, SelectionKey.OP_ACCEPT);
			
			while (true) {
				selector.select(); // blocking method
				Set<SelectionKey> set = selector.selectedKeys();
				Iterator<SelectionKey> iterator = set.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove(); // 拿到当前key实例之后记得在迭代器中将这个元素删除，非常重要，否则会出错
					try {
						if (key.isAcceptable()) {
							doAccept(key);
						} else if (key.isReadable()) {
							doRead(key);
						} else if (key.isWritable() && key.isValid()) {
							doWrite(key);
						} else if (key.isConnectable()) {
							System.out.println("Connect successfully.");
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

	private void doAccept(SelectionKey key) throws Exception {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		try {
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.register(this.selector, SelectionKey.OP_READ);
			System.out.println("Server is listening in looping.");
		} catch (IOException e) {
			throw new Exception("doAccept has error.", e);
		}
	}

	private void doRead(SelectionKey key) throws Exception {
		try {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
			long bytesRead = socketChannel.read(byteBuffer);
			while (bytesRead > 0) {
				byteBuffer.flip();
				byte[] data = byteBuffer.array();
				String info = new String(data).trim();
				System.out.println("Client say:" + info);
				byteBuffer.clear();
				bytesRead = socketChannel.read(byteBuffer);
			}
			if (bytesRead == -1) {
				socketChannel.close();
			}
		} catch (IOException e) {
			throw new Exception("doRead has error.", e);
		}
	}

	private void doWrite(SelectionKey key) throws Exception {
		try {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				socketChannel.write(byteBuffer);
			}
			byteBuffer.compact();
		} catch (IOException e) {
			throw new Exception("doWrite has error.", e);
		}
	}
	
	public static void main(String[] args) {
		new Server().init();
	}
}
