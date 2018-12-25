package org.baeldung.multimodule.library.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Carlos Montoya
 * @since 25/12/2018
 */
@Entity
@Data
public class Company
{
	@Id
	@GeneratedValue
	private Integer id;
	private String legalName;
	private String address;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<Employee> employees;
}
