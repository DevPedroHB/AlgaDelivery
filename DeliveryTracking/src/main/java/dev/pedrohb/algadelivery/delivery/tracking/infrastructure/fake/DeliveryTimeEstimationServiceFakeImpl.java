package dev.pedrohb.algadelivery.delivery.tracking.infrastructure.fake;

import java.time.Duration;

import org.springframework.stereotype.Service;

import dev.pedrohb.algadelivery.delivery.tracking.domain.model.ContactPoint;
import dev.pedrohb.algadelivery.delivery.tracking.domain.service.DeliveryEstimate;
import dev.pedrohb.algadelivery.delivery.tracking.domain.service.DeliveryTimeEstimationService;

@Service
public class DeliveryTimeEstimationServiceFakeImpl implements DeliveryTimeEstimationService {
  @Override
  public DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver) {
    return new DeliveryEstimate(
        Duration.ofHours(3),
        3.1);
  }
}
