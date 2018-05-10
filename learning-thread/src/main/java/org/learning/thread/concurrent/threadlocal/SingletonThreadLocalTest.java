package org.learning.thread.concurrent.threadlocal;

import java.util.Random;

public class SingletonThreadLocalTest {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					String port = String.valueOf(new Random().nextInt(10000));
					String host = "Sever" + port;

					Connection.getConnection().setHost(host);
					Connection.getConnection().setPort(port);
				}
			}.start();
		}
	}

	static class Connection {
		private static ThreadLocal<Connection> map = new ThreadLocal<Connection>();
		private String host;
		private String port;

		private Connection() {
		}

		public static Connection getConnection() {
			Connection conn = map.get();
			if (conn == null) {
				conn = new Connection();
				map.set(conn);
			}
			return conn;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		@Override
		public String toString() {
			return "Connection [host=" + host + ", port=" + port + "]";
		}
	}
}
