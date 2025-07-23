package dev.pedrohb.algadelivery.delivery.tracking.api.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierIdInput {
  private UUID courierId;
}
