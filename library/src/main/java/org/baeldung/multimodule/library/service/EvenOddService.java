package org.baeldung.multimodule.library.service;

import org.springframework.stereotype.Service;

/**
 * @author Carlos Montoya
 * @since 24/12/2018
 */
@Service
public class EvenOddService
{
	public String isEvenOrOdd(Integer number)
	{
		return number % 2 == 0? "Even" : "Odd";
	}
}
