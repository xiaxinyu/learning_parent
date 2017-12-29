package org.learning.design.pattern.interpreter;

public class PlusExpression extends AbstractExpression {
	private AbstractExpression left;
	private AbstractExpression right;

	public PlusExpression(AbstractExpression left, AbstractExpression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpreter(Context ctx) {
		return left.interpreter(ctx) + right.interpreter(ctx);
	}
}
