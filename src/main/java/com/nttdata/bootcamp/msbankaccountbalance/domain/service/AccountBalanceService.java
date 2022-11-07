package com.nttdata.bootcamp.msbankaccountbalance.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.msbankaccountbalance.application.incoming.CreateAccountBalanceUseCase;
import com.nttdata.bootcamp.msbankaccountbalance.application.incoming.ValidateBalanceUseCase;
import com.nttdata.bootcamp.msbankaccountbalance.application.outgoing.CreateAccountBalancePort;
import com.nttdata.bootcamp.msbankaccountbalance.application.outgoing.FindAccountBalanceByAccountNumberPort;
import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import reactor.core.publisher.Mono;

/**.*/
@Service
public class AccountBalanceService implements CreateAccountBalanceUseCase,
											  ValidateBalanceUseCase{

  @Autowired
  private CreateAccountBalancePort createAccountBalanceAccountPort;
  
  @Autowired
  private FindAccountBalanceByAccountNumberPort findAccountBalanceByAccountNumberPort;
  

@Override
public Mono<AccountBalance> createBalanceAccount(AccountBalance accountBalance) {
	return createAccountBalanceAccountPort.createBalanceAccount(accountBalance);
}

@Override
public Mono<Boolean> validateBalance(String accountNumber, double amount) {
	return findAccountBalanceByAccountNumberPort.findAccountBalanceByAccountNumber(accountNumber)
			.flatMap(b -> (Double.valueOf(b.getAccountBalanceAmount())
						.compareTo(Double.valueOf(amount))>=0)
					  ? Mono.just(Boolean.TRUE)
				      : Mono.just(Boolean.FALSE));
}
  

}
