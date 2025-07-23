package dev.pedrohb.algadelivery.delivery.tracking.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class ContactPoint {
  private String zipCode;
  private String street;
  private String number;
  private String complement;
  private String name;
  private String phone;
}
