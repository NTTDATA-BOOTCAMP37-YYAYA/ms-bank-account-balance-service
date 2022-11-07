package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.web.rest.adapter.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccountBalanceValidate {
  
  private int httpStatus;
  private Boolean validate;
  private String message;

}