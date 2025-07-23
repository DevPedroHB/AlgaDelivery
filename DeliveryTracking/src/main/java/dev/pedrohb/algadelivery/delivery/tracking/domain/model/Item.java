package dev.pedrohb.algadelivery.delivery.tracking.domain.model;

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
public class Item {
  @EqualsAndHashCode.Include
  private UUID id;
  private String name;
  @Setter(AccessLevel.PACKAGE)
  private Integer quantity;

  public static Item brandNew(String name, Integer quantity) {
    Item item = new Item();

    item.setId(UUID.randomUUID());
    item.setName(name);
    item.setQuantity(quantity);

    return item;
  }
}
