package org.baeldung.multimodule.application.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.baeldung.multimodule.library.service.EvenOddService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author Carlos Montoya
 * @since 26/12/2018
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class PrinterJob extends QuartzJobBean
{
	private final EvenOddService evenOddService;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		int n = (int) (Math.random() * 100);
		log.info("Printer job is working!... {} is {}",
				() -> n,
				() -> evenOddService.isEvenOrOdd(n));
	}
}
