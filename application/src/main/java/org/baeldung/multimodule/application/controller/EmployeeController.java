package org.baeldung.multimodule.application.controller;

import lombok.RequiredArgsConstructor;
import org.baeldung.multimodule.library.domain.Employee;
import org.baeldung.multimodule.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Carlos Montoya
 * @since 24/12/2018
 */
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeController
{
	private final EmployeeRepository employeeRepository;

	@GetMapping("/find-all")
	private List<Employee> findAll()
	{
		return employeeRepository.findAllBy();
	}
}
