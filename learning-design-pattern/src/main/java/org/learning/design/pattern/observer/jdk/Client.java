package org.learning.design.pattern.observer.jdk;

public class Client {
	public static void main(String[] args) {
		NewsPaper newsPaper = new NewsPaper();
		
		Reader reader1 = new Reader("SUMMER");
		Reader reader2 = new Reader("AUTUMN");
		Reader reader3 = new Reader("SPRING");
		Reader reader4 = new Reader("WINTER");
		
		newsPaper.addObserver(reader1);
		newsPaper.addObserver(reader2);
		newsPaper.addObserver(reader3);
		newsPaper.addObserver(reader4);
		
		newsPaper.setContent("SZ news");
	}
}
