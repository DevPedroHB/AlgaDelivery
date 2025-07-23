package dev.pedrohb.algadelivery.delivery.tracking.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;

import dev.pedrohb.algadelivery.delivery.tracking.domain.exception.DomainException;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.Delivery.PreparationDetails;

public class DeliveryTest {
  @Test
  public void shouldChangeToPlaced() {
    Delivery delivery = Delivery.draft();

    delivery.editPreparationDetails(createdValidPreparationDetails());

    delivery.place();

    assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
    assertNotNull(delivery.getPlacedAt());
  }

  @Test
  public void shouldNotPlace() {
    Delivery delivery = Delivery.draft();

    assertThrows(DomainException.class, () -> {
      delivery.place();
    });

    assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
    assertNull(delivery.getPlacedAt());
  }

  private PreparationDetails createdValidPreparationDetails() {
    ContactPoint sender = ContactPoint.builder()
        .zipCode("12345-123")
        .street("An example street")
        .number("123")
        .complement("An example complement")
        .name("John Doe")
        .phone("(19) 99999-9999")
        .build();
    ContactPoint recipient = ContactPoint.builder()
        .zipCode("12345-123")
        .street("An example street")
        .number("123")
        .complement("An example complement")
        .name("Jane Doe")
        .phone("(12) 12345-1234")
        .build();

    return Delivery.PreparationDetails.builder()
        .sender(sender)
        .recipient(recipient)
        .distanceFee(new BigDecimal("15.00"))
        .courierPayout(new BigDecimal("5.00"))
        .expectedDeliveryTime(Duration.ofHours(5))
        .build();
  }
}
