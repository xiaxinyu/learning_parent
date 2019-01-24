package org.learning.data.structure.map;

import java.util.HashMap;

public class HashMapLoadFactorTest {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(16, 100);
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(16, 0.5f);
		// Performance is the best, make enough initial capacity and load factor is
		// default.
		HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>(100);
		HashMap<Integer, Integer> map4 = new HashMap<Integer, Integer>();

		// part1
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			map.put(i, i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		// part2
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			map2.put(i, i);
		}
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);

		// part3
		long t5 = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			map3.put(i, i);
		}
		long t6 = System.currentTimeMillis();
		System.out.println(t6 - t5);

		// part4
		long t7 = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			map4.put(i, i);
		}
		long t8 = System.currentTimeMillis();
		System.out.println(t8 - t7);
	}
}
