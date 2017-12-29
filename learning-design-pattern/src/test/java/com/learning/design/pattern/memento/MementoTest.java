package com.learning.design.pattern.memento;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.learning.design.pattern.memonto.Caretaker;
import com.learning.design.pattern.memonto.Originator;
import com.learning.design.pattern.memonto.Status;

public class MementoTest {
	@Test
	public void testMemento() {
		Originator o = new Originator();
		Caretaker c = new Caretaker();

		o.setStatus(Status.INIT);
		c.saveMemento(o.createMemento());

		o.setStatus(Status.WAITING_PAY);
		c.saveMemento(o.createMemento());

		o.setStatus(Status.WAITING_SENT);
		c.saveMemento(o.createMemento());

		o.setStatus(Status.WAITING_RECEIVE);
		c.saveMemento(o.createMemento());

		Assert.assertEquals(o.getStatus(), Status.WAITING_RECEIVE);

		o.restoreMemento(c.getMemento(Status.WAITING_PAY));

		Assert.assertEquals(o.getStatus(), Status.WAITING_PAY);
	}
}
