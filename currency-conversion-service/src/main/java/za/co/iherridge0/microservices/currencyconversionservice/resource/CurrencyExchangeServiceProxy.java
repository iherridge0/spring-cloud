package za.co.iherridge0.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import za.co.iherridge0.microservices.currencyconversionservice.entity.CurrencyConversion;

@FeignClient(name = "currency-conversion-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
