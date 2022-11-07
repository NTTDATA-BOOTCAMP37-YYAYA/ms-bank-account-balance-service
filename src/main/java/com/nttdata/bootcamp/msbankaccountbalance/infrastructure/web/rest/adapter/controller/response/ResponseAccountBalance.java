package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.web.rest.adapter.controller.response;

import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccountBalance {
  
  private int httpStatus;
  private AccountBalance account;
  private String message;

}