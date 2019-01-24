package org.learning.data.structure.map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String, String> tables = new Hashtable<String, String>();
		tables.put("summer", "summer1");
		tables.put("winner", "winner1");
		tables.put("spring", "spring1");
		tables.put("autumn", "autumn1");

		/*Enumeration<String> enums = tables.elements();
		while (enums.hasMoreElements()) {
			System.out.println(enums.nextElement());
		}*/

		Set<Map.Entry<String, String>> set = tables.entrySet();
		Iterator<Map.Entry<String, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}
}
