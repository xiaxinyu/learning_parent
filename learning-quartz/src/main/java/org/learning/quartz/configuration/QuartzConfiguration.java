package org.learning.quartz.configuration;

import org.learning.quartz.job.TestFirstJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetail testJobDetail() {
		return JobBuilder.newJob(TestFirstJob.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
				.withIdentity("job1", "group1") // 定义name/group
				.usingJobData("name", "quartz") // 定义属性
				.build();
	}

	@Bean
	public Trigger testTrigger() {
		return TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") // 定义name/group
				.startNow()// 一旦加入scheduler，立即生效
				.withSchedule(SimpleScheduleBuilder.simpleSchedule() // 使用SimpleTrigger
						.withIntervalInSeconds(1) // 每隔一秒执行一次
						.repeatForever()) // 一直执行，奔腾到老不停歇
				.build();
	}

	@Bean
	public Scheduler testScheduler(JobDetail testJobDetail, Trigger testTrigger) {
		Scheduler scheduler = null;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(testJobDetail, testTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return scheduler;
	}
}
