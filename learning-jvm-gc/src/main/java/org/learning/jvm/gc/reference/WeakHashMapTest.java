package org.learning.jvm.gc.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 设置参数 -Xmx2m -Xms2m<br>
 */
public class WeakHashMapTest {
	public static void main(String[] args) {
		Map<String, Object> map = null;

		// Work normally
		map = new WeakHashMap<String, Object>();
		for (int i = 0; i < 10000; i++) {
			map.put("key" + i, new byte[i]);
		}

		//Work abnormally
		map = new HashMap<String, Object>();
		for (int i = 0; i < 10000; i++) {
			map.put("key" + i, new byte[i]);
		}
	}
}
