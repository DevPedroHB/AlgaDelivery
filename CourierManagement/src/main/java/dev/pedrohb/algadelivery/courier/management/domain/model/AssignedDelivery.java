package dev.pedrohb.algadelivery.courier.management.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AssignedDelivery {
  @EqualsAndHashCode.Include
  private UUID id;
  private OffsetDateTime assignedAt;

  public static AssignedDelivery pending(UUID deliveryId) {
    AssignedDelivery assignedDelivery = new AssignedDelivery();

    assignedDelivery.setId(deliveryId);
    assignedDelivery.setAssignedAt(OffsetDateTime.now());

    return assignedDelivery;
  }
}
