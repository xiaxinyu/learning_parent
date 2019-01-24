package org.learning.jvm.gc.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
	public static void main(String[] args) {
		WeakReferenceObject referent = new WeakReferenceObject();
		WeakReference<WeakReferenceObject> sr = new WeakReference<WeakReferenceObject>(referent);
		referent = null;

		System.out.println(sr.get());
		System.gc();
		System.out.println(sr.get());
	}
}

class WeakReferenceObject {

}