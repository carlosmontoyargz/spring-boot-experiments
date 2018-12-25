package org.baeldung.multimodule.library.repository;

import org.baeldung.multimodule.library.domain.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos Montoya
 * @since 25/12/2018
 */
public interface CompanyRepository
		extends CrudRepository<Company, Integer>
{
}
