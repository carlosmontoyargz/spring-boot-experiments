package org.baeldung.multimodule.application.controller;

import org.baeldung.multimodule.library.service.EvenOddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos Montoya
 * @since 24/12/2018
 */
@RestController
@RequestMapping("/validate")
public class EvenOddController
{
	private final EvenOddService evenOddService;

	@Autowired
	public EvenOddController(EvenOddService evenOddService)
	{
		this.evenOddService = evenOddService;
	}

	@GetMapping("/{n}")
	public String isEvenOrOdd(@PathVariable("n") Integer n)
	{
		return evenOddService.isEvenOrOdd(n);
	}
}
