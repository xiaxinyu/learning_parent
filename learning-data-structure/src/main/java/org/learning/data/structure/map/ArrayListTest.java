package org.learning.data.structure.map;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(3);
		list.add("summer");
		list.add("winner");
		list.add("autumn");
		list.add("spring");
		for (String value : list) {
			System.out.println(value);
		}
		
		System.out.println(3>>1);
		System.out.println(4>>1);
	}
}
