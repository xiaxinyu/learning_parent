package org.learning.jvm.gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
	public static void main(String[] args) {
		PhantomReferenceObject referent = new PhantomReferenceObject();

		ReferenceQueue<PhantomReferenceObject> queue = new ReferenceQueue<PhantomReferenceObject>();
		PhantomReference<PhantomReferenceObject> sr = new PhantomReference<PhantomReferenceObject>(referent, queue);
		referent = null;

		System.out.println(sr.get());
		System.gc();
		System.out.println(sr.get());
	}
}

class PhantomReferenceObject {

}