package org.baeldung.multimodule.library.config;

import lombok.extern.log4j.Log4j2;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlos Montoya
 * @since 14/01/2019
 */
@Configuration
@Log4j2
public class HibernateConfiguration
{
	private final JpaProperties jpaProperties;

	@Autowired
	public HibernateConfiguration(JpaProperties jpaProperties)
	{
		this.jpaProperties = jpaProperties;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			MultiTenantConnectionProvider multiTenantConnectionProviderImpl,
			CurrentTenantIdentifierResolver currentTenantIdentifierResolverImpl)
	{
		Map<String, Object> properties = new HashMap<>(jpaProperties.getProperties());
		properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
		properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProviderImpl);
		properties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolverImpl);
		properties.put(Environment.IMPLICIT_NAMING_STRATEGY, new SpringImplicitNamingStrategy());
		properties.put(Environment.PHYSICAL_NAMING_STRATEGY, new SpringPhysicalNamingStrategy());
		log.info("JpaProperties map {}", properties);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("org.baeldung.multimodule.library.domain");
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setJpaPropertyMap(properties);
		return em;
	}
}
