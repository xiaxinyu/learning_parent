package org.learning.thread.concurrent.pvolatile;

class Output extends Thread{
	private volatile boolean flag = true;
	
	public void stopMe() {
		this.flag  =  false;
	}
	
	@Override
	public void run() {
		while(this.flag) {
			System.out.println("I am running！");
		}
	}
}

public class VolatileTest {
	public static void main(String[] args) throws InterruptedException {
		Output out = new Output();
		out.start();
		Thread.sleep(1000);
		out.stopMe();
		Thread.sleep(1000);
	}
}


