package org.learning.data.structure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("summer", "oracle");
		map.put("winner", "java");
		map.put("winner", "javascript");
		map.put("spring", "python");

		map.put("red", "summer");
		map.put("green", "peek");
		map.put("black", "java");
		map.put("orange", "king");

		map.put("sunny", "apple");
		map.put("rainny", "pair");
		map.put("winndy", "banana");
		map.put("snowy", "durian");
		
		map.put("sea", "fish");
		map.put("sun", "shake");
		System.out.println(map.get("winner"));
		
		System.out.println(2<<1);
		
		System.out.println(2&3);
		
		System.out.println(60>>>3);
		
		//loop
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}
}
