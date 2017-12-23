package org.learning.design.pattern.state;

import org.apache.log4j.Logger;

public class RepeatVoteState implements VoteState {
	private Logger logger = Logger.getLogger(RepeatVoteState.class);
	private VotePerson person;

	public RepeatVoteState(VotePerson person) {
		this.person = person;
	}

	@Override
	public void vote(String candidate) {
		logger.info("Repeat: " + person.getName() + " vote " + candidate);
	}
}
