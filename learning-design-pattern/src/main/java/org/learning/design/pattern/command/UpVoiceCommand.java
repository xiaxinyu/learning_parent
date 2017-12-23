package org.learning.design.pattern.command;

public class UpVoiceCommand implements Command {
	private Receiver receiver;

	public UpVoiceCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void action() {
		receiver.execute();
	}
}
