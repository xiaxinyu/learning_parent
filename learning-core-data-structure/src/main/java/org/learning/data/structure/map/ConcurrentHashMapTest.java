package org.learning.data.structure.map;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("restriction")
public class ConcurrentHashMapTest {

	// Unsafe mechanics
	private static final sun.misc.Unsafe U;
	private static final long SIZECTL;
	private static final long TRANSFERINDEX;
	private static final long BASECOUNT;
	private static final long CELLSBUSY;

	public static sun.misc.Unsafe getUnsafeInstance() throws Exception {
		Field theUnsafeInstance = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		return (sun.misc.Unsafe) theUnsafeInstance.get(sun.misc.Unsafe.class);

	}

	static {
		try {
			U = getUnsafeInstance();
			Class<?> k = ConcurrentHashMap.class;
			SIZECTL = U.objectFieldOffset(k.getDeclaredField("sizeCtl"));
			TRANSFERINDEX = U.objectFieldOffset(k.getDeclaredField("transferIndex"));
			BASECOUNT = U.objectFieldOffset(k.getDeclaredField("baseCount"));
			CELLSBUSY = U.objectFieldOffset(k.getDeclaredField("cellsBusy"));
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	static final int resizeStamp(int n) {
		return Integer.numberOfLeadingZeros(n) | (1 << (16 - 1));
	}

	public static void invoke() {
		long i = 0;
		System.out.println(U.compareAndSwapInt(ConcurrentHashMapTest.class, i, 0, 3));
		System.out.println(i);
	}

	public static void loop() {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		map.put("red", "summer");
		map.put("green", "peek");
		map.put("black", "java");
		map.put("orange", "king");

		// loop
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

	public static void main(String[] args) {
		invoke();

		System.out.println(resizeStamp(16));
	}
}
