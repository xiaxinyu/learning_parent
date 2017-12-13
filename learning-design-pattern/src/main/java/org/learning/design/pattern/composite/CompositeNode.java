package org.learning.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeNode implements Node {
	private List<Node> nodeList = new ArrayList<Node>();
	private String nodeName;
	private static int deep = 0;

	public CompositeNode() {
	}

	public CompositeNode(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public void setNode(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String getNode() {
		return this.nodeName;
	}

	@Override
	public void addNode(Node node) {
		nodeList.add(node);
	}

	@Override
	public void removeNode(Node node) {
		nodeList.remove(node);
	}

	@Override
	public List<Node> getChildren() {
		return this.nodeList;
	}

	@Override
	public String getNodePath() {
		String str = this.nodeName;
		if (nodeList != null && nodeList.size() > 0) {
			deep++;
			String space = "";
			for (int i = 0; i < deep; i++) {
				space += "  ";
			}
			for (Node node : nodeList) {
				str = str + "\n" + space + node.getNodePath();
			}
			deep--;
		}
		return str;
	}

}
