package org.learning.design.pattern.command;

public class Button {
	private String name;
	private Command command;

	public Button(String name, Command command) {
		this.name = name;
		this.command = command;
	}

	public void invoke() {
		this.command.action();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
