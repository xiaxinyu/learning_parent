package org.learning.socket.server.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5209);
			System.out.println("客户端启动成功");

			new ClientSenderHandle(socket).start();
			new ClientReceiverHandle(socket).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ClientSenderHandle extends Thread {
	private Socket socket;

	public ClientSenderHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter write = new PrintWriter(socket.getOutputStream());

			while (true && socket.isConnected()) {
				if (socket.isClosed() || socket.isOutputShutdown()) {
					break;
				}
				String readline = reader.readLine();
				write.println(readline);
				write.flush();
				System.out.println("Client send:" + readline);
				if (readline.equals("exit")) {
					break;
				}
			}

			reader.close();
			write.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ClientReceiverHandle extends Thread {
	private Socket socket;

	public ClientReceiverHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				if (isServerClose(socket)) {
					break;
				}
				String line = in.readLine();
				System.out.println("Client receive:" + line);
				if (line.equalsIgnoreCase("exit")) {
					System.out.println("Client: client exit session.");
					break;
				}
			}
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isServerClose(Socket socket) {
		try {
			socket.sendUrgentData(0xFF);
			return false;
		} catch (Exception se) {
			return true;
		}
	}

}
