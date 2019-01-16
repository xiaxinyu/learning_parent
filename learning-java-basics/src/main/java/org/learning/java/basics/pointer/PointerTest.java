package org.learning.java.basics.pointer;

public class PointerTest {
	public static void main(String[] args) {
		Student stu1 = null;
		Student stu2 = null;
		if ((stu1 = stu2) == null) {
			stu2 = new Student("summer");
		}
		System.out.println(stu1 == stu2);
	}
}

class Student {
	private String name;

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
