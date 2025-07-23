package dev.pedrohb.algadelivery.delivery.tracking.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.pedrohb.algadelivery.delivery.tracking.domain.exception.DomainException;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.Delivery;
import dev.pedrohb.algadelivery.delivery.tracking.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryCheckpointService {
  private final DeliveryRepository deliveryRepository;

  public void place(UUID deliveryId) {
    Delivery delivery = this.deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException());

    delivery.place();

    this.deliveryRepository.saveAndFlush(delivery);
  }

  public void pickUp(UUID deliveryId, UUID courierId) {
    Delivery delivery = this.deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException());

    delivery.pickUp(courierId);

    this.deliveryRepository.saveAndFlush(delivery);
  }

  public void complete(UUID deliveryId) {
    Delivery delivery = this.deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException());

    delivery.markAsDelivered();

    this.deliveryRepository.saveAndFlush(delivery);
  }
}
