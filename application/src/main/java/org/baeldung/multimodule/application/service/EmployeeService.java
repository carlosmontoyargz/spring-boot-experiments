package org.baeldung.multimodule.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.baeldung.multimodule.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Carlos Montoya
 * @since 25/12/2018
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class EmployeeService
{
	private final EmployeeRepository employeeRepository;

	@Transactional
	public void printEmployee(Integer id)
	{
		employeeRepository
				.findById(id)
				.ifPresent(log::info);
	}
}
