package com.practice.moneytransferapp.controllers;

import com.practice.moneytransferapp.domains.Account;
import com.practice.moneytransferapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
//accepts requests from user and send the req to  service layer

    @Autowired
    private AccountService accountService;

    @PostMapping("/api/account/create")
    public Account createAccount(@RequestBody Account account){

        return accountService.createAccount(account);
    }

    @GetMapping("/api/account/list")
    public Iterable listAccount(){
        return accountService.allAccounts();
    }
}