package org.learning.design.pattern.state;

import org.apache.log4j.Logger;

public class NormalVoteState implements VoteState {
	private Logger logger = Logger.getLogger(NormalVoteState.class);
	private VotePerson person;

	public NormalVoteState(VotePerson person) {
		this.person = person;
	}

	@Override
	public void vote(String candidate) {
		logger.info("Normal: " + person.getName() + " vote " + candidate);
	}

}
