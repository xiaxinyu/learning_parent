package org.learning.data.structure.map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapTest {
	public static void main(String[] args) {
		/*TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("summer", "oracle");
		treeMap.put("winner", "java");
		treeMap.put("autumn", "javascript");
		treeMap.put("spring", "python");

		Set<Entry<String, String>> set = treeMap.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}*/

		TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
		tree.put(12, "summer1");
		tree.put(8, "summer2");
		tree.put(9, "summer3");
		tree.put(88, "summer4");
		tree.put(100, "summer5");
		tree.put(2, "summer6");
		tree.put(7, "summer7");
		tree.put(6, "summer8");
		tree.put(34, "summer9");
		tree.put(67, "summer10");

		Set<Integer> setKey = tree.keySet();
		Iterator<Integer> iteratorKey = setKey.iterator();
		while (iteratorKey.hasNext()) {
			System.out.println(iteratorKey.next());
		}

	}
}
