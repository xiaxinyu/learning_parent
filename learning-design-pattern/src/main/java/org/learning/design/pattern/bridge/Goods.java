package org.learning.design.pattern.bridge;

import org.apache.log4j.Logger;

public interface Goods {
	public Logger logger = Logger.getLogger(Goods.class);
	public void showIntention();
}
