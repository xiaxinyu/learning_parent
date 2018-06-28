package org.learning.cas;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class UnsafeTest {
	private static Unsafe unsafe;

	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
		} catch (Exception e) {
			System.out.println("Get Unsafe instance occur error" + e);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class clazz = Target.class;
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("fieldName:fieldOffset");
		for (Field f : fields) {
			// 获取属性偏移量，可以通过这个偏移量给属性设置
			System.out.println(f.getName() + ":" + unsafe.objectFieldOffset(f));
		}
		Target target = new Target();
		Field intFiled = clazz.getDeclaredField("intParam");
		int a = (Integer) intFiled.get(target);
		System.out.println("原始值是:" + a);
		// intParam的字段偏移是12 原始值是3 我们要改为10
		System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
		int b = (Integer) intFiled.get(target);
		System.out.println("改变之后的值是:" + b);

		// 这个时候已经改为10了,所以会返回false
		System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));

		System.out.println(unsafe.compareAndSwapObject(target, 24, null, "5"));
	}
}

class Target {
	int intParam = 3;
	long longParam;
	String strParam;
	String strParam2;
}
