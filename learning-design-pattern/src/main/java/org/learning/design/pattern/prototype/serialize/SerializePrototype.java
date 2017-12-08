package org.learning.design.pattern.prototype.serialize;

import java.io.Serializable;

public class SerializePrototype implements Serializable {
	private static final long serialVersionUID = 6658632894565730373L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
