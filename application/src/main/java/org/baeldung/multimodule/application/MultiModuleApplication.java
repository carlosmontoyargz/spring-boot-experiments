package org.baeldung.multimodule.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Aplicacion Spring Boot para experimentacion.
 *
 * @author Carlos Montoya
 * @since 24/12/2018
 */
@SpringBootApplication(scanBasePackages = "org.baeldung.multimodule")
@EnableJpaRepositories(basePackages = "org.baeldung.multimodule.library.repository")
@EntityScan(basePackages = "org.baeldung.multimodule.library.domain")
public class MultiModuleApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MultiModuleApplication.class, args);
	}
}
