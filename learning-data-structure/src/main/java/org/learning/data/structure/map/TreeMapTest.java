package org.learning.data.structure.map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("summer", "oracle");
		treeMap.put("winner", "java");
		treeMap.put("autumn", "javascript");
		treeMap.put("spring", "python");
		
		Set<Entry<String, String>> set =treeMap.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}
}
