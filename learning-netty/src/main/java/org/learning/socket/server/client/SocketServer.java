package org.learning.socket.server.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		new SocketServer().createServer();
	}

	public void createServer() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5209);
			System.out.println("服务器启动成功");
		} catch (Exception e) {
			System.out.println("没有启动监听：" + e);
		}

		try {
			while (true) {
				Socket socket = server.accept();
				new ServerReceiverHandle(socket).start();
				new ServerSenderHandle(socket).start();
			}
		} catch (Exception e) {
			System.out.println("Error." + e);
		}
	}
}

class ServerReceiverHandle extends Thread {
	private Socket socket;

	public ServerReceiverHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String handleName = "ReceiverHandle-" + Thread.currentThread().getName();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String line = in.readLine();
			while (true) {
				System.out.println(handleName + ":" + line);
				if (line.equalsIgnoreCase("exit")) {
					System.out.println(handleName + ": client exit session.");
					break;
				}
				if (socket.isClosed()) {
					break;
				}
				line = in.readLine();
			}
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerSenderHandle extends Thread {
	private Socket socket;

	public ServerSenderHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String handleName = "SenderHandle-" + Thread.currentThread().getName();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter write = new PrintWriter(socket.getOutputStream());

			String readline;
			readline = reader.readLine();
			while (true) {
				write.println(readline);
				write.flush();
				System.out.println(handleName + " send:" + readline);
				if (readline.equals("exit")) {
					break;
				}
				if (socket.isClosed()) {
					break;
				}
				readline = reader.readLine();
			}

			reader.close();
			write.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
