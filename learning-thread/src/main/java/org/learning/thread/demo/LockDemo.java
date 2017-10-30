package org.learning.thread.demo;

class G extends Thread{
	private Object obj1;
	private Object obj2;
	
	public G(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		synchronized (obj1) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			
			System.out.println("G stoped");
			synchronized (obj2) {
				
			}
		}
	}
}

class H extends Thread{
	private Object obj1;
	private Object obj2;
	
	public H(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		synchronized (obj2) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			
			System.out.println("H stoped");
			synchronized (obj1) {
				
			}
		}
	}
}

public class LockDemo {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		G g = new G(obj1, obj2);
		H h = new H(obj1, obj2);

		g.start();
		h.start();
	}
}
