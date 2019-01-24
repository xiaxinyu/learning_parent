package org.learning.jvm.gc.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 设置参数 -Xmx2m -Xms2m<br>
 * 打开被注释掉的new byte[1024*100]语句，这条语句请求一块大的堆空间，使堆内存使用紧张。并显式的再调用一次GC
 */
public class SoftRerferenceTest {
	public static void main(String[] args) {
		SoftRerferenceObject referent = new SoftRerferenceObject();
		SoftReference<SoftRerferenceObject> sr = new SoftReference<SoftRerferenceObject>(referent);
		referent = null;
		System.gc();
		System.out.println(sr.get());

		List<byte[]> data = new ArrayList<byte[]>();
		data.add(new byte[1024 * 512]); //It's difficult to match exact threshold value
		System.gc();

		System.out.println(sr.get());
	}
}

class SoftRerferenceObject {

}