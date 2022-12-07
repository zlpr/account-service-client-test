package com.account.service.client.test.client;

import com.account.service.client.test.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "asc", url = "http://localhost:8006")
public interface AccountServiceClient {

    @GetMapping("/accounts/{id}")
    Long getAmount(@PathVariable Integer id);

    @PostMapping("/accounts/")
    void addAmount(@RequestBody Account account);

    @PutMapping("/accounts/")
    Account create(@RequestParam Long amount);

}
