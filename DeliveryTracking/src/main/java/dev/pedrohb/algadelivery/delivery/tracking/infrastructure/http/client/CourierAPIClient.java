package dev.pedrohb.algadelivery.delivery.tracking.infrastructure.http.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@HttpExchange("/api/v1/couriers")
public interface CourierAPIClient {
  @PostExchange("/payout-calculation")
  @Retry(name = "Retry_CourierAPIClient_payoutCalculation")
  @CircuitBreaker(name = "CircuitBreaker_CourierAPIClient_payoutCalculation")
  CourierPayoutResultModel payoutCalculation(@RequestBody CourierPayoutCalculationInput input);
}
