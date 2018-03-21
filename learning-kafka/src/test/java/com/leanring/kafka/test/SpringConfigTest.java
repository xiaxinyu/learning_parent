package com.leanring.kafka.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.kafka.core.Constant;
import com.learning.kafka.core.Listener;
import com.learning.kafka.entity.Message;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SpringConfigTest {
	
	@Autowired
	private Listener listener;

	@Autowired
	private KafkaTemplate<Integer, String> template;
	
	@Test
	public void testAutoCommitInSpring() throws Exception {
		template.send(Constant.TOPIC, new Message("summer", "This is summer's message.").toString());
	    template.flush();
	    Assert.assertTrue(this.listener.latch1.await(10, TimeUnit.SECONDS));
	}
	
}
