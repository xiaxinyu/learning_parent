package org.learning.design.pattern.prototype.lightcopy;

import org.apache.log4j.Logger;
import org.learning.design.pattern.prototype.LightCopyPrototypeTest;

/**
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
