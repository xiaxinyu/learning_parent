package org.learning.thread.base;

class A {

}

class B extends Thread {
	private A a;

	public B(A a) {
		this.a = a;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (a) {
				i++;
				System.out.println("This is B");
				if (i % 3 == 0) {
					try {
						a.wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}

class C extends Thread {
	private A a;

	public C(A a) {
		this.a = a;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (a) {
				i++;
				System.out.println("This is C");
				if (i % 3 == 0) {
					a.notify();
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}

public class WaitDemo {
	public static void main(String[] args) {
		A a = new A();
		B b = new B(a);
		C c = new C(a);

		b.start();
		c.start();
	}
}
