package dev.pedrohb.algadelivery.courier.management.infrastructure.event;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryFulfilledIntegrationEvent {
  private OffsetDateTime occurredAt;
  private UUID deliveryId;
}
