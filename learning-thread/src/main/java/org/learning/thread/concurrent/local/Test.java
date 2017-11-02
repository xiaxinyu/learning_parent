package org.learning.thread.concurrent.local;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {
	private static Map<Thread, String> threadData = new HashMap<Thread, String>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					String port = String.valueOf(new Random().nextInt(10000));
					String host = "Sever" + port;

					Connection.getConnection().setHost(host);
					Connection.getConnection().setPort(port);

					threadData.put(Thread.currentThread(), host);

					new A().get();
					new B().get();
				}
			}.start();
		}
	}

	static class A {
		public void get() {
			Thread current = Thread.currentThread();
			String host = threadData.get(current);
			System.out.println("A->" + current.getName() + "->" + host);
			Connection conn = Connection.getConnection();
			System.out.println("A->Local->" + current.getName() + "->" + conn.getHost() + "->" + conn.getPort());
		}
	}

	static class B {
		public void get() {
			Thread current = Thread.currentThread();
			String host = threadData.get(current);
			System.out.println("B->" + current.getName() + "->" + host);
			Connection conn = Connection.getConnection();
			System.out.println("B->Local->" + current.getName() + "->" + conn.getHost() + "->" + conn.getPort());
		}
	}
}
