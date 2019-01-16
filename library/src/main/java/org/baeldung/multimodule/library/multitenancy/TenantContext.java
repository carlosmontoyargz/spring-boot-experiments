package org.baeldung.multimodule.library.multitenancy;

import lombok.extern.log4j.Log4j2;

/**
 * @author Carlos Montoya
 * @since 14/01/2019
 */
@Log4j2
public class TenantContext
{
	private static ThreadLocal<String> currentTenant = ThreadLocal.withInitial(() -> "public");
	public final static String DEFAULT_TENANT = "public";

	public static void setCurrentTenant(String tenant)
	{
		log.debug("Setting tenant to " + tenant);
		currentTenant.set(tenant);
	}

	public static String getCurrentTenant()
	{
		return currentTenant.get();
	}

	public static void clear()
	{
		currentTenant.set(DEFAULT_TENANT);
	}
}
