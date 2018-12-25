package org.baeldung.multimodule.application;

import lombok.RequiredArgsConstructor;
import org.baeldung.multimodule.application.service.CompanyService;
import org.baeldung.multimodule.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Carlos Montoya
 * @since 25/12/2018
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MultiModuleRunner implements CommandLineRunner
{
	private final EmployeeService employeeService;
	private final CompanyService companyService;

	@Override
	public void run(String... args)
	{
		companyService.printCompany(2001);

//		employeeService.printEmployee(1001);
//		employeeService.printEmployee(1002);
	}
}
