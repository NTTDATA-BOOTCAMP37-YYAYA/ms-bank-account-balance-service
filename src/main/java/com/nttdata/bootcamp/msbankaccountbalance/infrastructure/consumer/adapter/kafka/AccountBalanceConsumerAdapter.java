package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.consumer.adapter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.msbankaccountbalance.application.incoming.CreateAccountBalanceUseCase;
import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountBalanceConsumerAdapter {


  @Autowired
  private CreateAccountBalanceUseCase  createAccountBalanceUseCase;

  
  @KafkaListener(topics = "${kafka.topic.bank.account-balance.create.name}")
  public void listenerCreate(@Payload AccountBalance accountBalance) {
	  createAccountBalanceUseCase.createBalanceAccount(accountBalance).block();
  }
  

}
