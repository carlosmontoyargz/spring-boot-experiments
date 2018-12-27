package org.baeldung.multimodule.application;

import lombok.RequiredArgsConstructor;
import org.baeldung.multimodule.application.job.PrinterJob;
import org.baeldung.multimodule.application.service.CompanyService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Carlos Montoya
 * @since 26/12/2018
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class QuartzRunner implements CommandLineRunner
{
	private final Scheduler scheduler;
	private final CompanyService companyService;

	@Override
	public void run(String... args) throws Exception
	{
		JobDetail jobDetail = jobDetail();
		Trigger trigger = trigger(jobDetail);
		scheduler.scheduleJob(jobDetail, trigger);
	}

	private JobDetail jobDetail()
	{
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("companyService", companyService);

		return JobBuilder.newJob(PrinterJob.class)
				.withIdentity("printer-job")
				.withDescription("Test job")
				.usingJobData(jobDataMap)
				.storeDurably()
				.build();
	}

	private Trigger trigger(JobDetail jobDetail)
	{
		return TriggerBuilder.newTrigger().forJob(jobDetail)
				.withIdentity("printer-job-trigger")
				.withDescription("Test trigger")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2))
				.build();
	}
}
