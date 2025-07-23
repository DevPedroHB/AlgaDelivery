package dev.pedrohb.algadelivery.courier.management.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.pedrohb.algadelivery.courier.management.api.model.CourierInput;
import dev.pedrohb.algadelivery.courier.management.domain.model.Courier;
import dev.pedrohb.algadelivery.courier.management.domain.repository.CourierRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CourierRegistrationService {
  private final CourierRepository courierRepository;

  public Courier create(@Valid CourierInput input) {
    Courier courier = Courier.brandNew(input.getName(), input.getPhone());

    return this.courierRepository.saveAndFlush(courier);
  }

  public Courier update(UUID courierId, @Valid CourierInput input) {
    Courier courier = this.courierRepository.findById(courierId).orElseThrow();

    courier.setPhone(input.getPhone());
    courier.setName(input.getName());

    return this.courierRepository.saveAndFlush(courier);
  }
}
