package dev.pedrohb.algadelivery.courier.management.api.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourierPayoutResultModel {
  private BigDecimal payoutFee;
}
