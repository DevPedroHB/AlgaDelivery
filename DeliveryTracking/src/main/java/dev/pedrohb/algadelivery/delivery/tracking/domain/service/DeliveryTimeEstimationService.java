package dev.pedrohb.algadelivery.delivery.tracking.domain.service;

import dev.pedrohb.algadelivery.delivery.tracking.domain.model.ContactPoint;

public interface DeliveryTimeEstimationService {
  DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver);
}
