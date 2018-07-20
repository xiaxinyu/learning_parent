package com.pratice.thread.concurrent.product.consume;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Baker extends Thread {
	private static final Integer NUM_BREAD_BAKED_BY_EVERYONE_EVERYDAY = 100;
	private BlockingQueue<String> cakes;
	private String bakerName;

	public Baker(String bakerName, BlockingQueue<String> cakes) {
		this.bakerName = bakerName;
		this.cakes = cakes;
	}

	@Override
	public void run() {
		for (int i = 1; i <= NUM_BREAD_BAKED_BY_EVERYONE_EVERYDAY; i++) {
			try {
				String bread = bakerName + " makes a cake successfully. The number of cake is " + i;
				System.out.println(bread);
				cakes.put(bread);
			} catch (InterruptedException e) {
				System.out.println(bakerName + " makes a cake unsuccessfully. The number of cake is " + i);
			}
		}
	}
}

class Customer extends Thread {
	private BlockingQueue<String> cakes;
	private String customerName;

	public Customer(String customerName, BlockingQueue<String> cakes) {
		this.customerName = customerName;
		this.cakes = cakes;
	}

	@Override
	public void run() {
		try {
			System.out.println(customerName + " buy a cake.  Cake is [" + cakes.take() + "]");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProductConsume {
	private static final Integer BAKER_NUMBER = 5;

	public void product(BlockingQueue<String> cakes) {
		ExecutorService pool = new ThreadPoolExecutor(BAKER_NUMBER, BAKER_NUMBER * 2, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(BAKER_NUMBER));

		for (int i = 1; i <= BAKER_NUMBER; i++) {
			pool.execute(new Baker("Baker" + i, cakes));
		}

		pool.shutdown();
	}

	public void consume(int customerNumber, BlockingQueue<String> cakes) {
		ExecutorService pool = new ThreadPoolExecutor(customerNumber, customerNumber * 2, 1000L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(customerNumber));
		for (int i = 1; i <= customerNumber; i++) {
			pool.execute(new Customer("Customer" + i, cakes));
		}

		pool.shutdown();
	}

	public static void main(String[] args) {
		BlockingQueue<String> cakes = new LinkedBlockingQueue<String>(100);
		ProductConsume pc = new ProductConsume();
		pc.product(cakes);
		pc.consume(300, cakes);

		while (true) {
			if (cakes.size() == 0) {
				System.out.println("There are " + cakes.size() + " pieces of bread left to eat.");
				System.exit(0);
			}
			System.out.println("There are " + cakes.size() + " pieces of bread left to eat.");
		}
	}
}
