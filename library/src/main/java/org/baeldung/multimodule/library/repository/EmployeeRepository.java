package org.baeldung.multimodule.library.repository;

import org.baeldung.multimodule.library.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Carlos Montoya
 * @since 24/12/2018
 */
public interface EmployeeRepository
		extends CrudRepository<Employee, Integer>
{
	List<Employee> findAllBy();
}
