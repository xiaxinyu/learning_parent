package org.learning.nio2.asyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Nio2Client {
	class ClientCompletionHandler implements CompletionHandler<Void, Void> {
		private AsynchronousSocketChannel channel;
		private CharBuffer charBuffer = null;
		private CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
		private BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

		ClientCompletionHandler(AsynchronousSocketChannel channel) {
			this.channel = channel;
		}

		public void completed(Void result, Void attachment) {
			try {
				System.out.println("输入客戶端请求：");
				String request = clientInput.readLine();
				// 发送客户端请求
				channel.write(ByteBuffer.wrap(request.getBytes())).get();
				// 创建读取的缓冲区
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
				// 读取服务端响应
				while (channel.read(buffer).get() != -1) {
					buffer.flip();
					charBuffer = decoder.decode(buffer);
					System.out.println(charBuffer.toString());
					if (buffer.hasRemaining()) {
						buffer.compact();
					} else {
						buffer.clear();
					}
					// 读取并发送下一次请求
					request = clientInput.readLine();
					channel.write(ByteBuffer.wrap(request.getBytes())).get();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					channel.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		public void failed(Throwable exc, Void attachment) {
			throw new RuntimeException("链接服务器端失败！");
		}
	}

	public void start() throws Exception {
		// 创建异步Socket通道
		AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
		if (channel.isOpen()) {
			channel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
			channel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
			channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
			// 链接服务器，指定CompletionHandler
			channel.connect(new InetSocketAddress("127.0.0.1", 8080), null, new ClientCompletionHandler(channel));
			// 主线程等待
			while (true) {
				Thread.sleep(5000);
			}
		} else {
			throw new RuntimeException("通道未打开！");
		}
	}

	public static void main(String[] args) throws Exception {
		Nio2Client client = new Nio2Client();
		client.start();
	}
}
