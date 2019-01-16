package org.baeldung.multimodule.library.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

/**
 * @author Carlos Montoya
 * @since 14/01/2019
 */
@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver
{
	@Override
	public String resolveCurrentTenantIdentifier()
	{
		return TenantContext.getCurrentTenant();
	}

	@Override
	public boolean validateExistingCurrentSessions() { return true; }
}
