package org.learning.data.structure.map;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("summer");
		list.add("winner");
		list.add("autumn");
		list.add("spring");
		for (String value : list) {
			System.out.println(value);
		}
	}
}
