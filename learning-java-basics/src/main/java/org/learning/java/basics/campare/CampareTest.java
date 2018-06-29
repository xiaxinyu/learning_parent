package org.learning.java.basics.campare;

import java.util.Arrays;

public class CampareTest {

	private static void reverseRange(Object[] a, int lo, int hi) {
		hi--;
		while (lo < hi) {
			Object t = a[lo];
			a[lo++] = a[hi];
			a[hi--] = t;
		}
	}

	public static void main(String[] args) {
		Student[] students = new Student[] { new Student("summer", 83), new Student("winter", 33),
				new Student("autumn", 30), new Student("spring", 10), new Student("old boy", 100),
				new Student("young boy", 2) };

		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("==========================================");

		Arrays.sort(students);

		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("==========================================");

		reverseRange(students, 0, 6);
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
