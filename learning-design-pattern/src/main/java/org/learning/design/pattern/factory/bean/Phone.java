package org.learning.design.pattern.factory.bean;

public class Phone {
	private String model;

	private String name;

	public Phone() {
	}

	public Phone(String model, String name) {
		super();
		this.model = model;
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			Phone p = (Phone) obj;
			if (p.getName().equals(name) && p.getModel().equals(model)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Phone [model=" + model + ", name=" + name + "]";
	}
}
