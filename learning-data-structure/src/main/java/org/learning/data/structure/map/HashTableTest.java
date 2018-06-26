package org.learning.data.structure.map;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String, String> tables = new Hashtable<>();
		tables.put("summer", "summer1");
		tables.put("winner", "winner1");
		tables.put("spring", "spring1");
		tables.put("autumn", "autumn1");

		Enumeration<String> enums = tables.elements();
		while(enums.hasMoreElements()) {
			System.out.println(enums.nextElement());
		}
	}
}
