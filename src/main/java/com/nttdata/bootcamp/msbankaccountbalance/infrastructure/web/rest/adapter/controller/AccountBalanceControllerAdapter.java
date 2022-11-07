package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.web.rest.adapter.controller;


import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msbankaccountbalance.application.incoming.ValidateBalanceUseCase;
import com.nttdata.bootcamp.msbankaccountbalance.infrastructure.web.rest.adapter.controller.response.ResponseAccountBalanceValidate;

import reactor.core.publisher.Mono;

/**.*/
@RestController
@RequestMapping("/accountBalance")
public class AccountBalanceControllerAdapter {

  final Logger logger = LoggerFactory.getLogger(AccountBalanceControllerAdapter.class);
  
  @Autowired
  private ValidateBalanceUseCase validateBalance;
  
  /**.*/
  @GetMapping("/validateAccountBalance/{accountNumber}/{amount}")
  public Mono<ResponseEntity<ResponseAccountBalanceValidate>> validateAccountBalance(@PathVariable("accountNumber") String accountNumber , @PathVariable("amount") double amount ) {
    return validateBalance.validateBalance(accountNumber,amount)
        .flatMap(validate -> 
              Mono.just(new ResponseEntity<ResponseAccountBalanceValidate>(
              new ResponseAccountBalanceValidate(HttpStatus.SC_CREATED, validate, "Account balance validation"),
              null, HttpStatus.SC_CREATED)))
        .switchIfEmpty(Mono.just(new ResponseEntity<ResponseAccountBalanceValidate>(
	               new ResponseAccountBalanceValidate(HttpStatus.SC_NOT_FOUND, null, "Account balance has not been found"),
	               null, HttpStatus.SC_NOT_FOUND)))
        .onErrorResume(e->Mono.just(new ResponseEntity<ResponseAccountBalanceValidate>(
                  new ResponseAccountBalanceValidate(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, e.getMessage()),
                  null, HttpStatus.SC_INTERNAL_SERVER_ERROR)));

  }



}
