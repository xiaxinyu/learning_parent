package org.learning.nio2.asyn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Nio2Server {
	private AsynchronousServerSocketChannel serverChannel;

	class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {
		private AsynchronousServerSocketChannel interServerChannel;
		private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		private CharBuffer charBuffer = null;
		private CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

		public ServerCompletionHandler(AsynchronousServerSocketChannel serverchannel) {
			this.interServerChannel = serverChannel;
		}

		public void completed(AsynchronousSocketChannel result, Void attachment) {
			// 立即接收下一个请求
			interServerChannel.accept(null, this);
			try {
				// 读取当前请求
				while (result.read(buffer).get() != -1) {
					buffer.flip();
					charBuffer = decoder.decode(buffer);
					String request = charBuffer.toString().trim();
					System.out.println("客服端请求：" + request);
					ByteBuffer outBuffer = ByteBuffer.wrap("请求收到".getBytes());
					// 将响应 输出到客服端
					result.write(outBuffer).get();
					if (buffer.hasRemaining()) {
						buffer.compact();
					} else {
						buffer.clear();
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					result.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		public void failed(Throwable exc, Void attachment) {
			// 立即接收下一个请求
			interServerChannel.accept(null, this);
			// 当前请求处理提示异常
			throw new RuntimeException("链接失败！");
		}
	}

	public void init() throws Exception {
		// 创建异步Socket通道
		serverChannel = AsynchronousServerSocketChannel.open();
		if (serverChannel.isOpen()) {
			serverChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
			serverChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
			// 绑定端口
			serverChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
		} else {
			throw new RuntimeException("通道未打开！");
		}
	}

	public void start() throws Exception {
		System.out.println("等待客服端请求......");
		serverChannel.accept(null, new ServerCompletionHandler(serverChannel));
		// 主线程等待
		while (true) {
			Thread.sleep(5000);
		}
	}

	public static void main(String[] args) throws Exception {
		Nio2Server server = new Nio2Server();
		server.init();
		server.start();
	}
}
