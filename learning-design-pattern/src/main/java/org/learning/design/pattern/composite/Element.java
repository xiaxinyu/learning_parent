package org.learning.design.pattern.composite;

import java.util.List;

/**
 * @author summer.xia
 */
public class Element implements Node {
	private String nodeName;

	public Element() {
	}

	public Element(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public void setNode(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String getNode() {
		return nodeName;
	}

	@Override
	public void addNode(Node node) {
	}

	@Override
	public void removeNode(Node node) {
	}

	@Override
	public List<Node> getChildren() {
		return null;
	}

	@Override
	public String getNodePath() {
		return this.nodeName;
	}

}
