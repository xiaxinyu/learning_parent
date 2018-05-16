package org.learning.spring.aop.plain;

import org.springframework.stereotype.Component;

@Component("knight")
public class BraveKnight {
	public void saying() {
		System.out.println("I am knight.");
	}
}