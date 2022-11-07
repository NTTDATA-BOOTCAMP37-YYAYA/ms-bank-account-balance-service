package com.nttdata.bootcamp.msbankaccountbalance.application.outgoing;

import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import reactor.core.publisher.Mono;

public interface CreateAccountBalancePort {

	Mono<AccountBalance> createBalanceAccount(AccountBalance accountBalance);
}
