package org.learning.thread.concurrent.local;

import java.util.Random;

public class ConnectionTest {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					String port = String.valueOf(new Random().nextInt(10000));
					String host = "Sever" + port;

					Connection.getConnection().setHost(host);
					Connection.getConnection().setPort(port);

					new A().get();
					new B().get();
				}
			}.start();
		}
	}

	static class A {
		public void get() {
			Thread current = Thread.currentThread();
			Connection conn = Connection.getConnection();
			System.out.println("A->Local->" + current.getName() + "->" + conn.getHost() + "->" + conn.getPort());
		}
	}

	static class B {
		public void get() {
			Thread current = Thread.currentThread();
			Connection conn = Connection.getConnection();
			System.out.println("B->Local->" + current.getName() + "->" + conn.getHost() + "->" + conn.getPort());
		}
	}
}
