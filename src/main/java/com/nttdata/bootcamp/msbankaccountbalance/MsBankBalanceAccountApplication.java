package com.nttdata.bootcamp.msbankaccountbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**.*/
@SpringBootApplication
@EnableEurekaClient
public class MsBankBalanceAccountApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsBankBalanceAccountApplication.class, args);
  }

}
