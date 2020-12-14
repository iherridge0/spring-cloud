package za.co.iherridge0.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import za.co.iherridge0.microservices.currencyconversionservice.resource.entity.CurrencyConversion;

@RestController
public class CurrencyCalculationController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		return new CurrencyConversion(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
	}

}
