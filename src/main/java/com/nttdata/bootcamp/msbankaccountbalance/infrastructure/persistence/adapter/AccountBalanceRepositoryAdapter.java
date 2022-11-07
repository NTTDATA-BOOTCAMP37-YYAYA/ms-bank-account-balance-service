package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.persistence.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.msbankaccountbalance.application.outgoing.CreateAccountBalancePort;
import com.nttdata.bootcamp.msbankaccountbalance.application.outgoing.FindAccountBalanceByAccountNumberPort;
import com.nttdata.bootcamp.msbankaccountbalance.domain.enums.States;
import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;
import com.nttdata.bootcamp.msbankaccountbalance.infrastructure.persistence.entity.AccountBalanceEntity;

import reactor.core.publisher.Mono;

/**.*/
@Component
public class AccountBalanceRepositoryAdapter implements CreateAccountBalancePort,
														FindAccountBalanceByAccountNumberPort{

  @Autowired
  private ReactiveMongoAccountBalanceRepository reactiveMongoDB;

@Override
public Mono<AccountBalance> createBalanceAccount(AccountBalance accountBalance) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
    String createDate = now.format(formatter);
    accountBalance.setAccountBalanceCreateDate(createDate);
    accountBalance.setAccountBalanceState(States.ACTIVE.getValue());
    return reactiveMongoDB.insert(AccountBalanceEntity.toAccountBalanceEntity(accountBalance))
                                 .map(AccountBalanceEntity::toAccountBalance);
}

@Override
public Mono<AccountBalance> findAccountBalanceByAccountNumber(String accountNumber) {
	return reactiveMongoDB.FindAccountBalanceByAccountNumberPort(accountNumber,States.ACTIVE.getValue())
				 .map(AccountBalanceEntity::toAccountBalance);
	

}




}
