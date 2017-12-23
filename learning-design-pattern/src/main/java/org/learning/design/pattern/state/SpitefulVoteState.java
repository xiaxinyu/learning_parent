package org.learning.design.pattern.state;

import org.apache.log4j.Logger;

public class SpitefulVoteState implements VoteState {
	private Logger logger = Logger.getLogger(SpitefulVoteState.class);
	private VotePerson person;

	public SpitefulVoteState(VotePerson person) {
		this.person = person;
	}

	@Override
	public void vote(String candidate) {
		logger.info("Spiteful: " + person.getName() + " vote " + candidate + ", put you in black list.");
	}
}
