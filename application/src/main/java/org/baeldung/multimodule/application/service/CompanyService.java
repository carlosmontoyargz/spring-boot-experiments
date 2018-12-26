package org.baeldung.multimodule.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.baeldung.multimodule.library.repository.CompanyRepository;
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
public class CompanyService
{
	private final CompanyRepository companyRepository;

	@Transactional
	public void printCompany(Integer id)
	{
		companyRepository
				.findById(id)
				.ifPresent(c ->
						log.info("{} Employees: {}", c, c.getEmployees()));
	}
}
