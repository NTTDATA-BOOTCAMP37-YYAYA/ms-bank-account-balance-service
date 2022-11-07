package com.nttdata.bootcamp.msbankaccountbalance.application.incoming;

import reactor.core.publisher.Mono;

public interface ValidateBalanceUseCase {

	Mono<Boolean> validateBalance(String accountNumber,double amount);
}
