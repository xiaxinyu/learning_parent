package com.pratice.thread.concurrent.product.consume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProductConsume {
	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	private int workerNum = 10;
	private int customerNum = 5;

	public void product() {
		ExecutorService pool = new ThreadPoolExecutor(workerNum / 2, workerNum, 1000L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(workerNum));
		while (true) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					queue.add("I buy a bread.");
				}
			});
		}
	}

	public void consume() {
		ExecutorService pool = new ThreadPoolExecutor(customerNum, customerNum, 1000L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(customerNum));
		while (true) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					queue.add("I finish making a bread.");
				}
			});
		}
	}

	
	public static void main(String[] args) {

	}
}
