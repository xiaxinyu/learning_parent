package org.learning.design.pattern.command;

import java.util.HashMap;
import java.util.Map;

public class Keyboard {
	private Map<String, Button> map = new HashMap<String, Button>();

	public void addButton(Button button) {
		map.put(button.getName(), button);
	}

	public void removeButton(Button button) {
		map.remove(button.getName());
	}
	
	public void click(String name) {
		map.get(name).invoke();
	}
}
