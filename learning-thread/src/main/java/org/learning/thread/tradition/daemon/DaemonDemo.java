package org.learning.thread.tradition.daemon;

import java.util.Scanner;

class U extends Thread {
	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			if (i % 10 == 0) {
				break;
			}
			System.out.println(this.getName() + " is running");
		}
	}
}

class D extends Thread {
	@Override
	public void run() {
		int i = 0;
		while (i < 10) {
			System.out.println("ffffffffffffffffffff");
			i++;
		}
	}
}

public class DaemonDemo {
	public static void main(String[] args) {
		U u1 = new U();
		U u2 = new U();
		U u3 = new U();
		u1.start();
		u2.start();
		u3.start();

		D d = new D();
		d.setDaemon(true);
		d.start();
		
		Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println("Main Thread Over!");
	}
}
