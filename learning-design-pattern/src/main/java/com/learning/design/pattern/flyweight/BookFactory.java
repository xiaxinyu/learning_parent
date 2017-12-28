package com.learning.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
	private static BookFactory bookFactory;
	private Map<Integer, IBook> bookMap = new HashMap<Integer, IBook>();

	private BookFactory() {
	}

	public static BookFactory getInstance() {
		if (bookFactory == null) {
			bookFactory = new BookFactory();
		}
		return bookFactory;
	}

	public IBook createBook(int id) {
		IBook book = null;
		book = this.bookMap.get(id);
		if (book == null) {
			book = new Book();
			book.setId(id);
			book.setName("name" + id);
			this.bookMap.put(id, book);
		}
		return book;
	}
}
