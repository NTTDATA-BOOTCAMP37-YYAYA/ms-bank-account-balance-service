package com.nttdata.bootcamp.msbankaccountbalance.application.outgoing;

import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import reactor.core.publisher.Mono;

public interface FindAccountBalanceByAccountNumberPort {

	Mono<AccountBalance> findAccountBalanceByAccountNumber(String accountNumber);
}
