package com.learning.design.pattern.interpreter;

public class MinusExpression extends AbstractExpression {
	private AbstractExpression left;
	private AbstractExpression right;

	public MinusExpression(AbstractExpression left, AbstractExpression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpreter(Context ctx) {
		return left.interpreter(ctx) - right.interpreter(ctx);
	}
}
