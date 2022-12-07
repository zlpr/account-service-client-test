package com.account.service.client.test;

import com.account.service.client.test.client.AccountServiceClient;
import com.account.service.client.test.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@Slf4j
@EnableFeignClients(clients = AccountServiceClient.class)
@SpringBootApplication
public class AccountServiceClientTestApplication {

    public static void main(String[] args){


        ApplicationContext context = SpringApplication.run(AccountServiceClientTestApplication.class, args);


        int start = 0;
        int end = 20000;
        var client = context.getBean(AccountServiceClient.class);

        new Thread(() -> {
            for (int i = start; i < end; i++) {
                client.create(1000L);
            }
        }).start();
        new Thread(() -> {
            for (int i = start; i < end; i++) {
                client.getAmount(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = start; i < end; i++) {
                client.addAmount(new Account(i, 10000L));
            }
        }).start();

        log.info("sdfsdfsdfad");


    }

}
