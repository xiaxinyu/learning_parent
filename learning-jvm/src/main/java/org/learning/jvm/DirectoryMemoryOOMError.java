package org.learning.jvm;

import java.nio.ByteBuffer;

public class DirectoryMemoryOOMError {
	private static final int SIZE = 1024 * 1024 * 1024 * 1024;
	private static int count = 1;
	private static boolean flag = true;

	public static void main(String[] args) {
		try {
			while (flag) {
				ByteBuffer.allocateDirect(SIZE);
				count++;
			}
		} catch (Exception e) {
			flag = false;
			System.out.println("Exception:instance created " + count);
			e.printStackTrace();
		}
	}
}