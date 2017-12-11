package org.learning.design.pattern.decoration;

import org.apache.log4j.Logger;

public class BusinessAnalyst extends AbstractProjectDecoration {
	private Logger logger = Logger.getLogger(BusinessAnalyst.class);

	public BusinessAnalyst(Project project) {
		super(project);
	}

	@Override
	public void beforeCoding() {
		logger.info("Analysis business request from Salers.");
	}
}