package com.practice.thread.concurrent.connection.pool;

class Connection {
	private String host;
	private String port;

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
}

class ConnectionManager{
	private ThreadLocal<Connection> thread = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			return new Connection();
		};
	};
}

public class ConnectionPool {
	
}
