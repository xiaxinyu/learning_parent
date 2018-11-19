package org.learning.thread.join;

public class Test {
	public static void main(String[] args) {
		Domino d1 = new Domino(null,"d1");
		Domino d2 = new Domino(d1, "d2");
		Domino d3 = new Domino(d2, "d3");

		d1.start();
		d2.start();
		d3.start();
	}

	private static class Domino extends Thread {
		private Thread thread;

		public Domino(Thread thread, String name) {
			this.thread = thread;
			super.setName(name);
		}

		@Override
		public void run() {
			if (thread != null) {
				try {
					thread.join();
				} catch (InterruptedException e) {
				}
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}
	}
}
