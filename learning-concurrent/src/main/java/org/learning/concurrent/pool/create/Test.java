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

	private static int runStateOf(int c) {
		System.out.println("~CAPACITY：" + ~CAPACITY + "，Binary：" + Integer.toBinaryString(~CAPACITY));
		return c & ~CAPACITY;
	}

	public static void main(String[] args) {
		System.out.println(workerCountOf(16));
		System.out.println(runStateOf(12));
		System.out.println("RUNNING    = " + (-1 << COUNT_BITS));

		System.out.println(2 << 6); // 128
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(-4));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(-1 << 1);
		
		int a = 3;
		int b = 2;
		System.out.println(a ^ b);
		System.out.println(((a & b) << 1) ^ (a ^ b));
		System.out.println(Integer.toBinaryString(Integer.parseInt("11110111", 2) + 1));
	}
}
