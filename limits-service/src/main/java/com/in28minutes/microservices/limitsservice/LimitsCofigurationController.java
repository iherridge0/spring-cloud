package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitsservice.bean.Configuration;
import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsCofigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveLimitsConfigurations() {
		
		throw new RuntimeException("Not Available");
	}
	
	/**
	 * On Error
	 * @return some default configuration back
	 */
	public LimitConfiguration fallbackRetrieveConfiguration() {
		
		return new LimitConfiguration(999,9);
	}
	
}
