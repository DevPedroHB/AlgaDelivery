package dev.pedrohb.algadelivery.courier.management.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Courier {
  @Id
  @EqualsAndHashCode.Include
  private UUID id;
  @Setter(AccessLevel.PUBLIC)
  private String name;
  @Setter(AccessLevel.PUBLIC)
  private String phone;
  private Integer fulfilledDeliveriesQuantity;
  private Integer pendingDeliveriesQuantity;
  private OffsetDateTime lastFulfilledDeliveryAt;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "courier")
  private List<AssignedDelivery> pendingDeliveries = new ArrayList<>();

  public List<AssignedDelivery> getPendingDeliveries() {
    return Collections.unmodifiableList(this.pendingDeliveries);
  }

  public static Courier brandNew(String name, String phone) {
    Courier courier = new Courier();

    courier.setId(UUID.randomUUID());
    courier.setName(name);
    courier.setPhone(phone);
    courier.setFulfilledDeliveriesQuantity(0);
    courier.setPendingDeliveriesQuantity(0);

    return courier;
  }

  public void assign(UUID deliveryId) {
    this.pendingDeliveries.add(AssignedDelivery.pending(deliveryId, this));

    this.setPendingDeliveriesQuantity(this.getPendingDeliveriesQuantity() + 1);
  }

  public void fulfill(UUID deliveryId) {
    AssignedDelivery assignedDelivery = this.pendingDeliveries.stream()
        .filter(d -> d.getId().equals(deliveryId)).findFirst().orElseThrow();

    this.pendingDeliveries.remove(assignedDelivery);

    this.setPendingDeliveriesQuantity(this.getPendingDeliveriesQuantity() - 1);
    this.setFulfilledDeliveriesQuantity(this.getFulfilledDeliveriesQuantity() + 1);
    this.setLastFulfilledDeliveryAt(OffsetDateTime.now());
  }
}
