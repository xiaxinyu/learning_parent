package org.learning.design.pattern.interpreter;

public class TerminalExpression extends AbstractExpression {
	private int value;
	private String varName;

	public TerminalExpression(int value) {
		this.value = value;
	}

	public TerminalExpression(String varName) {
		this.varName = varName;
	}

	@Override
	public int interpreter(Context ctx) {
		if (this.varName != null) {
			return ctx.get(this.varName);
		} else {
			return this.value;
		}
	}
}