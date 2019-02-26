package org.learning.concurrent.pool.create;

public class Test {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY = (1 << COUNT_BITS) - 1;

	private static int workerCountOf(int c) {
		System.out.println("COUNT_BITS：" + COUNT_BITS + ", Binary：" + Integer.toBinaryString(COUNT_BITS));
		System.out.println(
				"(1 << COUNT_BITS)：" + (1 << COUNT_BITS) + ", Binary：" + Integer.toBinaryString((1 << COUNT_BITS)));
		System.out.println("CAPACITY：" + CAPACITY + ", Binary：" + Integer.toBinaryString(CAPACITY));
		return c & CAPACITY;
	}

	public static void main(String[] args) {
		System.out.println(workerCountOf(16));
		System.out.println(2 << 6); //128
	}
}
