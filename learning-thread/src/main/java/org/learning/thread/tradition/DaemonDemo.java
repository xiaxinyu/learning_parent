package org.learning.thread.tradition;

class D extends Thread {
	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			if (i % 10000 == 0) {
				break;
			}
			System.out.println(this.getName() + " is running");
		}
	}
}

class F extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("ffffffffffffffffffff");
		}
	}
}

public class DaemonDemo {
	public static void main(String[] args) {
		D d1 = new D();
		D d2 = new D();
		D d3 = new D();
		d1.start();
		d2.start();
		d3.start();

		F f = new F();
		f.setDaemon(true);
		f.start();
	}
}
