package org.learning.data.structure.collection;

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
		
		//ArrayList grow by this way which is oldCapacity + oldCapacity>>1(oldCapacity*0.5)
		System.out.println(10>>1);
	}
}
