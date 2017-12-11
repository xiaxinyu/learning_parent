package org.learning.design.pattern.decoration;

import org.apache.log4j.Logger;

public class Tester extends AbstractProjectDecoration {
	private Logger logger = Logger.getLogger(Tester.class);

	public Tester(Project project) {
		super(project);
	}

	@Override
	public void afterCoding() {
		logger.info("Test and submit project.");
	}
}