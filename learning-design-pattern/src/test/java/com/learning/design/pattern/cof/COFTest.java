package com.learning.design.pattern.cof;

import org.junit.Test;
import org.learning.design.pattern.cof.Auditing;
import org.learning.design.pattern.cof.DepartmentManager;
import org.learning.design.pattern.cof.Manager;
import org.learning.design.pattern.cof.TeamLeader;
import org.learning.design.pattern.cof.Worker;

public class COFTest {
	@Test
	public void testCOF() {
		Auditing manager = new Manager(null);
		Auditing deptManager = new DepartmentManager(manager);
		Auditing leader = new TeamLeader(deptManager);
		Auditing worker = new Worker(leader);

		worker.approve(500);
		worker.approve(1500);
	}
}
