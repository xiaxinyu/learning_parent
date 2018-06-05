package org.learning.bio.single.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(9000);
			// server.accept() blocking method
			Socket socket = serverSocket.accept();
			new ServerListener(socket).start();
			new ServerSender(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server().init();
	}
}

class ServerListener extends Thread {
	private Socket socket = null;
	private boolean exit = false;

	public ServerListener(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while (!exit) {
				String info = null;
				while ((info = bufferedReader.readLine()) != null) {
					System.out.println("I am server,client say: " + info);
					if ("exit".equalsIgnoreCase(info)) {
						exit = true;
					}
				}
			}
			if (this.socket != null && this.socket.isConnected()) {
				socket.shutdownInput();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (this.socket != null) {
					this.socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class ServerSender extends Thread {
	private Socket socket = null;

	public ServerSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) {
				String msg = scanner.next();
				printWriter.write(msg);
				printWriter.flush();
				if ("exit".equalsIgnoreCase(msg)) {
					break;
				}
			}
			scanner.close();
			socket.shutdownOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
