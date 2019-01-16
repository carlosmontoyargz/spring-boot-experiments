package org.baeldung.multimodule.library.multitenancy;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Carlos Montoya
 * @since 14/01/2019
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider
{
	private final DataSource dataSource;

	@Override
	public Connection getAnyConnection() throws SQLException
	{
		return dataSource.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException
	{
		connection.close();
	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException
	{
		final Connection connection = getAnyConnection();
		try
		{
			connection
					.createStatement()
					.execute("SET search_path = \"" + tenantIdentifier + "\"");
		}
		catch (SQLException e)
		{
			throw new HibernateException
					("Problem setting schema to " + tenantIdentifier, e);
		}

		return connection;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException
	{
		try
		{
			connection
					.createStatement()
					.execute("SET search_path = \"" + TenantContext.DEFAULT_TENANT + "\"");
		}
		catch (SQLException e)
		{
			throw new HibernateException
					("Problem setting schema to " + tenantIdentifier, e);
		}

		releaseAnyConnection(connection);
	}

	@Override
	public boolean supportsAggressiveRelease()
	{
		return true;
	}

	@Override
	public boolean isUnwrappableAs(Class unwrapType)
	{
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType)
	{
		return null;
	}
}
