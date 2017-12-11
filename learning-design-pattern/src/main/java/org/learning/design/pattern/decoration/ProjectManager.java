package org.learning.design.pattern.decoration;

import org.apache.log4j.Logger;

public class ProjectManager extends AbstractProjectDecoration {
	private Logger logger = Logger.getLogger(ProjectManager.class);
	
	public ProjectManager(Project project) {
		super(project);
	}	
}