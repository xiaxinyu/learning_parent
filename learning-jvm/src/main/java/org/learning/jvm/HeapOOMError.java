package org.learning.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class HeapOOMError {

	public static void main(String[] args) {
		List<ByteBuffer> list = new ArrayList<ByteBuffer>();
		int i = 0;
		boolean flag = true;
		while (flag) {
			try {
				i++;
				list.add(ByteBuffer.allocate(1024*1024));
			} catch (Throwable e) {
				flag = false;
				e.printStackTrace();
			}
		}
		System.out.println("count=" + i);// 记录运行的次数
	}
}
