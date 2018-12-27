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
//		CompanyService companyService = (CompanyService)
//				context.getMergedJobDataMap().get("companyService");
//
//		companyService.printCompany(2001);

		log.info("Printer job is working!... 42 is {}",
				() -> evenOddService.isEvenOrOdd(42));
	}
}
