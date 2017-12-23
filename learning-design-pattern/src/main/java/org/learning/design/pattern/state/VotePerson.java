package org.learning.design.pattern.state;

import java.util.HashMap;
import java.util.Map;

public class VotePerson {
	private String name;
	private VoteState state;
	private Map<String, Integer> voteItemCount = new HashMap<String, Integer>();

	public VotePerson(String name) {
		this.name = name;
	}

	public void vote(String candidate) {
		Integer count = this.voteItemCount.get(candidate);
		if (count == null) {
			count = 0;
		}
		count++;
		this.voteItemCount.put(candidate, count);
		if (count == 1) {
			this.state = new NormalVoteState(this);
		} else if (count <= 5 && !(this.state instanceof RepeatVoteState)) {
			this.state = new RepeatVoteState(this);
		} else if (count > 5 && !(this.state instanceof SpitefulVoteState)) {
			this.state = new SpitefulVoteState(this);
		}
		this.state.vote(candidate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
