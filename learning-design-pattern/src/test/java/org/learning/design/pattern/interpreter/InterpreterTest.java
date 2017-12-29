package org.learning.design.pattern.interpreter;

import org.junit.Assert;
import org.junit.Test;

public class InterpreterTest {
	@Test
	public void testInterpreter() {
		/*
		 * int a = 1; int b = 2; a + 1*4/2 - b;
		 */
		Context c = new Context();
		c.add("a", 1);
		c.add("b", 2);

		TerminalExpression a = new TerminalExpression("a");
		TerminalExpression b = new TerminalExpression("b");
		TerminalExpression n1 = new TerminalExpression(1);
		TerminalExpression n4 = new TerminalExpression(4);
		TerminalExpression n2 = new TerminalExpression(2);

		MultiplicationExpression mu = new MultiplicationExpression(n1, n4);
		DivisionExpression di = new DivisionExpression(mu, n2);
		PlusExpression pl = new PlusExpression(a, di);
		MinusExpression mi = new MinusExpression(pl, b);

		int result = mi.interpreter(c);
		Assert.assertEquals(result, 1);
	}
}
