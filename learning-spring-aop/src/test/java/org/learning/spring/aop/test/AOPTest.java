package org.learning.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.spring.aop.plain.BraveKnight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class AOPTest {

	@Autowired
	private BraveKnight knight;

	@Test
	public void testSaying() {
		knight.saying();
	}
}
