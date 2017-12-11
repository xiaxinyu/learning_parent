package org.learning.design.pattern.decoration;

/**
 * @author summer.xiasz
 */
public abstract class AbstractProjectDecoration implements Project {
	private Project project;

	public AbstractProjectDecoration(Project project) {
		this.project = project;
	}

	/**
	 * before coding, do something
	 */
	public void beforeCoding() {
	}

	/**
	 * after coding, do something
	 */
	public void afterCoding() {
	}

	@Override
	public void coding() {
		beforeCoding();
		project.coding();
		afterCoding();
	}
}
