package org.learning.design.pattern.state;

import org.junit.Test;
import org.learning.design.pattern.state.VotePerson;

public class StateTest {
	@Test
	public void testState() {
		VotePerson p = new VotePerson("summer");

		for (int i = 0; i < 10; i++) {
			p.vote("Chairman Mao");
		}
	}
}
