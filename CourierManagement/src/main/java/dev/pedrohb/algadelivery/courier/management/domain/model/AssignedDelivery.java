package dev.pedrohb.algadelivery.courier.management.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AssignedDelivery {
  @Id
  @EqualsAndHashCode.Include
  private UUID id;
  private OffsetDateTime assignedAt;
  @ManyToOne(optional = false)
  @Getter(AccessLevel.PRIVATE)
  private Courier courier;

  public static AssignedDelivery pending(UUID deliveryId, Courier courier) {
    AssignedDelivery assignedDelivery = new AssignedDelivery();

    assignedDelivery.setId(deliveryId);
    assignedDelivery.setAssignedAt(OffsetDateTime.now());
    assignedDelivery.setCourier(courier);

    return assignedDelivery;
  }
}
