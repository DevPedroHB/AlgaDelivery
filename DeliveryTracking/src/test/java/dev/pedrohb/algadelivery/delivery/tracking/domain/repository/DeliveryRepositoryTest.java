package dev.pedrohb.algadelivery.delivery.tracking.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.pedrohb.algadelivery.delivery.tracking.domain.model.ContactPoint;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.Delivery;
import dev.pedrohb.algadelivery.delivery.tracking.domain.model.Delivery.PreparationDetails;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeliveryRepositoryTest {

  @Autowired
  private DeliveryRepository deliveryRepository;

  @Test
  public void shouldPersist() {
    Delivery delivery = Delivery.draft();

    delivery.editPreparationDetail(createdValidPreparationDetails());

    delivery.addItem("An example product 01", 2);
    delivery.addItem("An example product 02", 3);

    deliveryRepository.saveAndFlush(delivery);

    Delivery persistedDelivery = deliveryRepository.findById(delivery.getId()).orElseThrow();

    assertEquals(2, persistedDelivery.getItems().size());
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
