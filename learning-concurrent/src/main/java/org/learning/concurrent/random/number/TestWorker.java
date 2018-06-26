package org.learning.concurrent.random.number;

public class TestWorker extends Thread {
	public TestWorker(String testWorker) {
		super.setName(testWorker);
	}

	@Override
	public void run() {
		while (true) {
			int rn = RandomNumber.getRandomNumber();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(getName() + " " + rn);
			if (rn == 5000 || rn == 9000) {
				System.out.print(" ,It's bound.");
			}
			if (rn < 5000 || rn > 9000) {
				System.out.print(" ,It's out of bound.");
			}
			System.out.println();
		}
	}
}
