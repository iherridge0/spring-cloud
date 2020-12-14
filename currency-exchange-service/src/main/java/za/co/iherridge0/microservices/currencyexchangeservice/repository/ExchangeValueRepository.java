package za.co.iherridge0.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.iherridge0.microservices.currencyexchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}
