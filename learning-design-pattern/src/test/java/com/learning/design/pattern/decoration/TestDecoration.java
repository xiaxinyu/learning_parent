package com.learning.design.pattern.decoration;

import org.junit.Test;
import org.learning.design.pattern.decoration.BusinessAnalyst;
import org.learning.design.pattern.decoration.Programer;
import org.learning.design.pattern.decoration.Project;
import org.learning.design.pattern.decoration.ProjectManager;
import org.learning.design.pattern.decoration.Saler;
import org.learning.design.pattern.decoration.Tester;

public class TestDecoration {
	@Test
	public void testCoding() {
		Project programer = new Programer();

		Project saler = new Saler(programer);
		saler.coding();

		Project ba = new BusinessAnalyst(programer);
		ba.coding();

		Project tester = new Tester(programer);
		tester.coding();
		
		Project manager = new ProjectManager(new Saler(new BusinessAnalyst(new Tester(new Programer()))));
		manager.coding();
	}
}
