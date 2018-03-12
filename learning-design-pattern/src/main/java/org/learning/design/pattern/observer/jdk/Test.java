package org.learning.design.pattern.observer.jdk;

public class Test {
	public static void main(String[] args) {
		Publisher newsPaper = new Publisher();

		Subcriber reader1 = new Subcriber("SUMMER");
		Subcriber reader2 = new Subcriber("AUTUMN");
		Subcriber reader3 = new Subcriber("SPRING");
		Subcriber reader4 = new Subcriber("WINTER");

		newsPaper.addObserver(reader1);
		newsPaper.addObserver(reader2);
		newsPaper.addObserver(reader3);
		newsPaper.addObserver(reader4);

		newsPaper.setMessage("SZ news");
	}
}
