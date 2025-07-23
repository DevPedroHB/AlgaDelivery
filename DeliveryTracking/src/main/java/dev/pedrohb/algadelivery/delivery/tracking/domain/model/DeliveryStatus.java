package dev.pedrohb.algadelivery.delivery.tracking.domain.model;

import java.util.Arrays;
import java.util.List;

public enum DeliveryStatus {
  DRAFT,
  WAITING_FOR_COURIER(DRAFT),
  IN_TRANSIT(WAITING_FOR_COURIER),
  DELIVERY(IN_TRANSIT);

  private final List<DeliveryStatus> previousStatus;

  private DeliveryStatus(DeliveryStatus... previousStatus) {
    this.previousStatus = Arrays.asList(previousStatus);
  }

  public boolean canNotChangeTo(DeliveryStatus status) {
    return !status.previousStatus.contains(this);
  }

  public boolean canChangeTo(DeliveryStatus status) {
    return !this.canNotChangeTo(status);
  }
}
