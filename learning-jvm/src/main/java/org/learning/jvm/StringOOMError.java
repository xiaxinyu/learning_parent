package org.learning.jvm;

/**
 * 设置方法区最大、最小空间：-XX:MetaspaceSize=5m -XX:MaxMetaspaceSize=5m<br>
 */
public class StringOOMError {
	static String base = "string";

	public static void main(String[] args) {
		String str = "";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			str += base;
		}
	}
}
