package org.learning.data.structure.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("summer");
		set.add("winner");
		set.add("spring");
		set.add("autumn");
		set.add("summer");
		set.add(null);

		//HashSet is implemented with HashMap
		//So, same element will be covered.
		//All elements will be stored in keys in HashMap.
		//Null element is legal.
		System.out.println(set);
	}
}
