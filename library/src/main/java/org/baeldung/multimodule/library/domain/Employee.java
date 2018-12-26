package org.baeldung.multimodule.library.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Carlos Montoya
 * @since 24/12/2018
 */
@Entity
@Data
public class Employee
{
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	private String firstName;
	private String lastName;
	private LocalDate birthday;
}
