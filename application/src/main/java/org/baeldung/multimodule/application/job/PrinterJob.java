package org.baeldung.multimodule.application.job;

import lombok.RequiredArgsConstructor;
import org.baeldung.multimodule.application.service.CompanyService;
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
public class PrinterJob extends QuartzJobBean
{
	private final CompanyService companyService;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		companyService.printCompany(2001);
	}
}
