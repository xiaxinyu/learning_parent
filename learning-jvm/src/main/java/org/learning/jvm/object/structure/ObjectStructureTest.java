package org.learning.jvm.object.structure;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ObjectStructureTest {
	public static void main(String[] args) throws Exception {
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(Person.class).toPrintable());
	}

	public static class Person {
		private String name;
		private int age;
		private long salary;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}
	}
}
