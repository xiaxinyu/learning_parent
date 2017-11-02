package org.learning.thread.concurrent.local;

public class Connection {
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
