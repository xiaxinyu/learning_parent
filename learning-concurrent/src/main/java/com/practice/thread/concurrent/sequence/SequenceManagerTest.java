package com.practice.thread.concurrent.sequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SequenceManager {
	private static ThreadLocal<Integer> sequences = new ThreadLocal<Integer>();

	public static Integer getSequence() {
		Integer sequence = sequences.get();
		if (sequence == null) {
			sequence = new Integer(0);
			System.out.println("Initianize sequence: " + Thread.currentThread().getName());
		}
		sequences.set(sequence + 1);
		return sequence;
	}
}

class Sequence extends Thread {
	private static final Integer MAX_SEQUENCE = 10;
	private String sequenceName;

	public Sequence(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	@Override
	public void run() {
		currentThread().setName(sequenceName);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int i = SequenceManager.getSequence();
			if (i > MAX_SEQUENCE) {
				break;
			}
			System.out.println(sequenceName + " gets " + i);
		}
	}
}

public class SequenceManagerTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 5; i++) {
			pool.execute(new Sequence("Sequence-Thool-" + i));
		}
	}
}