package com.nttdata.bootcamp.msbankaccountbalance.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**.*/
@AllArgsConstructor
@NoArgsConstructor
public enum States {

  ACTIVE("A"),
  INACTIVE("I");
  
  private String value;

  public String getValue() {
    return value;
  }



}
