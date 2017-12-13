package org.learning.design.pattern.composite;

import java.util.List;

/**
 * @author summer.xia
 */
public interface Node {
	/**
	 * set node
	 * 
	 * @param nodeName
	 */
	public void setNode(String nodeName);

	/**
	 * get node
	 * 
	 * @return node
	 */
	public String getNode();

	/**
	 * add node
	 * 
	 * @param node
	 */
	public void addNode(Node node);

	/**
	 * remove node
	 * 
	 * @param node
	 */
	public void removeNode(Node node);

	/**
	 * get child nodes
	 * 
	 * @return
	 */
	public List<Node> getChildren();

	/**
	 * get node path
	 * 
	 * @return
	 */
	public String getNodePath();
}
