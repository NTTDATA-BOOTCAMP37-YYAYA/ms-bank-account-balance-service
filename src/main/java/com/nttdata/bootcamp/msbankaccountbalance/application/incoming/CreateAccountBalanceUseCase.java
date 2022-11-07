package com.nttdata.bootcamp.msbankaccountbalance.application.incoming;

import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import reactor.core.publisher.Mono;

public interface CreateAccountBalanceUseCase {

	Mono<AccountBalance> createBalanceAccount(AccountBalance accountBalance);
}
