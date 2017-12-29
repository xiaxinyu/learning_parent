package com.learning.design.pattern.interpreter;

import java.util.Hashtable;
import java.util.Map;

public class Context {
	private Map<String, Integer> values = new Hashtable<String, Integer>();

	public void add(String varName, Integer value) {
		this.values.put(varName, value);
	}

	public Integer get(String varName) {
		return this.values.get(varName);
	}
}
