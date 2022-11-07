package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.persistence.adapter;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.msbankaccountbalance.infrastructure.persistence.entity.AccountBalanceEntity;

import reactor.core.publisher.Mono;

/**.*/
public interface ReactiveMongoAccountBalanceRepository extends ReactiveMongoRepository
                                                        <AccountBalanceEntity, String> {
  
	
	  
	  @Query("{'accountNumber': ?0, 'accountBalanceState' : ?1}")
	  public Mono<AccountBalanceEntity> FindAccountBalanceByAccountNumberPort(String accountNumber,String accountState);

}