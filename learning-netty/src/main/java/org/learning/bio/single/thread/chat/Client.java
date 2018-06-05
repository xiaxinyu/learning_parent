package org.learning.bio.single.thread.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void init() {
		try {
			Socket socket = new Socket("localhost", 9000);
			new ClientListener(socket).start();
			new ClientSender(socket).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client().init();
	}
}

class ClientListener extends Thread {
	private Socket socket = null;
	private boolean exit = false;

	public ClientListener(Socket socket) {
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
					System.out.println("I am client,server say: " + info);
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

class ClientSender extends Thread {
	private Socket socket = null;

	public ClientSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String msg = reader.readLine();
				writer.write(msg);
				writer.flush();
				if ("exit".equalsIgnoreCase(msg)) {
					break;
				}
			}
			socket.shutdownOutput();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
