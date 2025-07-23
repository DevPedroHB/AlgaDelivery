package dev.pedrohb.algadelivery.delivery.tracking.domain.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.pedrohb.algadelivery.delivery.tracking.api.model.ContactPointInput;
import dev.pedrohb.algadelivery.delivery.tracking.api.model.DeliveryInput;
import dev.pedrohb.algadelivery.delivery.tracking.api.model.ItemInput;
import dev.pedrohb.algadelivery.delivery.tracking.domain.exception.DomainException;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.ContactPoint;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.Delivery;
import dev.pedrohb.algadelivery.delivery.tracking.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryPreparationService {

  private final DeliveryRepository deliveryRepository;

  @Transactional
  public Delivery draft(DeliveryInput input) {
    Delivery delivery = Delivery.draft();

    this.handlePreparation(input, delivery);

    return this.deliveryRepository.saveAndFlush(delivery);
  }

  @Transactional
  public Delivery edit(UUID deliveryId, DeliveryInput input) {
    Delivery delivery = this.deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException());

    delivery.removeItems();

    this.handlePreparation(input, delivery);

    return this.deliveryRepository.saveAndFlush(delivery);
  }

  private void handlePreparation(DeliveryInput input, Delivery delivery) {
    ContactPointInput senderInput = input.getSender();
    ContactPointInput recipientInput = input.getRecipient();

    ContactPoint sender = ContactPoint.builder()
        .phone(senderInput.getPhone())
        .name(senderInput.getName())
        .complement(senderInput.getComplement())
        .number(senderInput.getNumber())
        .zipCode(senderInput.getZipCode())
        .street(senderInput.getStreet())
        .build();

    ContactPoint recipient = ContactPoint.builder()
        .phone(recipientInput.getPhone())
        .name(recipientInput.getName())
        .complement(recipientInput.getComplement())
        .number(recipientInput.getNumber())
        .zipCode(recipientInput.getZipCode())
        .street(recipientInput.getStreet())
        .build();

    Duration expectedDeliveryTime = Duration.ofHours(3);
    BigDecimal payout = new BigDecimal("10");

    BigDecimal distanceFee = new BigDecimal("10");

    Delivery.PreparationDetails preparationDetails = Delivery.PreparationDetails.builder()
        .recipient(recipient)
        .sender(sender)
        .expectedDeliveryTime(expectedDeliveryTime)
        .courierPayout(payout)
        .distanceFee(distanceFee)
        .build();

    delivery.editPreparationDetails(preparationDetails);

    for (ItemInput itemInput : input.getItems()) {
      delivery.addItem(itemInput.getName(), itemInput.getQuantity());
    }
  }
}
