package org.learning.design.pattern.decoration;

import org.apache.log4j.Logger;

public class Saler extends AbstractProjectDecoration {
	private Logger logger = Logger.getLogger(Saler.class);

	public Saler(Project project) {
		super(project);
	}

	@Override
	public void beforeCoding() {
		logger.info("Analysis market situation.");
	}
}