package com.nttdata.bootcamp.msbankaccountbalance.infrastructure.persistence.entity;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bootcamp.msbankaccountbalance.domain.model.AccountBalance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "AccountBalance")
public class AccountBalanceEntity {

	@Id
	private String accountBalanceId;
	private String accountId;
	private double accountBalanceAmount;
	private long accountBalanceQuantityTransaction;
	private String accountBalanceState;  

  /**.*/
  public static AccountBalance toAccountBalance(AccountBalanceEntity accountBalanceEntity) {
	AccountBalance accountBalance = new AccountBalance();
    BeanUtils.copyProperties(accountBalanceEntity, accountBalanceEntity);
    return accountBalance;
  }
  
  /**.*/
  public static AccountBalanceEntity toAccountBalanceEntity(AccountBalance accountBalance) {
    AccountBalanceEntity accountBalanceEntity = new AccountBalanceEntity();
    BeanUtils.copyProperties(accountBalance, accountBalanceEntity);
    return accountBalanceEntity;
  }
}
