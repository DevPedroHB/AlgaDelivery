package dev.pedrohb.algadelivery.delivery.tracking.domain.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeliveryStatusTest {

  @Test
  public void draft_canChangeToWaitingForCourier() {
    assertTrue(DeliveryStatus.DRAFT.canChangeTo(DeliveryStatus.WAITING_FOR_COURIER));
  }

  @Test
  public void draft_canChangeToInTransit() {
    assertTrue(DeliveryStatus.DRAFT.canNotChangeTo(DeliveryStatus.IN_TRANSIT));
  }
}
