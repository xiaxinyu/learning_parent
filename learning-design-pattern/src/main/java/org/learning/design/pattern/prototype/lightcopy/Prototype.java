package org.learning.design.pattern.prototype.lightcopy;

import org.apache.log4j.Logger;
import org.learning.design.pattern.prototype.LightCopyPrototypeTest;

/**
 * 浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象。
 * @author summer.xia
 */
public class Prototype implements Cloneable {
	private Logger logger = Logger.getLogger(LightCopyPrototypeTest.class);
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
