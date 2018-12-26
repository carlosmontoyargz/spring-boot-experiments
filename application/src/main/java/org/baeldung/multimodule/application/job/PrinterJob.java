package org.baeldung.multimodule.application.job;

import org.baeldung.multimodule.application.service.CompanyService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Carlos Montoya
 * @since 26/12/2018
 */
public class PrinterJob extends QuartzJobBean
{
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		CompanyService companyService = (CompanyService)
				context.getMergedJobDataMap().get("companyService");

		companyService.printCompany(2001);
	}
}
