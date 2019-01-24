package org.learning.data.structure.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorThreadSaftyTest {
 private static Vector<Integer> vector1 = new Vector<Integer>(); 

	private static List<Integer> vector = new ArrayList<Integer>();
	
	private static LinkedList<Integer> vector2 = new LinkedList<Integer>();

	public static void main(String[] args) {
		while (true) {
			// synchronized (vector) {
			
			// }

			Thread removeThread = new Thread(new Runnable() {
				@Override
				public void run() {
					 synchronized (vector) {
					for (int i = 0; i < vector.size(); i++) {
						vector.remove(i);
					}
				}
				 }
			});

			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {
					 synchronized (vector) {
					for (int i = 0; i < 10; i++) {
						vector.add(i);
					}
				}
				 }
			});

			removeThread.start();
			printThread.start();
			// 不要同时产生过多的线程，否则会导致操作系统假死
			while (Thread.activeCount() > 20)
				;
		}
	}
}
