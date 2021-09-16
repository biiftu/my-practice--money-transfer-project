package com.practice.moneytransferapp.services;

import com.practice.moneytransferapp.domains.Account;
import com.practice.moneytransferapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class AccountService {
    // implements the business logic like validations
    // calls the repo
    //returns  responses to controller

    @Autowired // because we can't create instance of interface//only one object is created ==> singleton
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        int age = calculateAge(account.getBirth_date(), LocalDate.now());
        if(age > 15){
            return accountRepository.save(account);
        }
        else {
            //do sth
            return null;
        }

    }

    public Iterable allAccounts(){
        return accountRepository.findAll();
    }
    private static int calculateAge(LocalDate birthdate, LocalDate currentdate){
        if(birthdate != null && currentdate != null){
            return Period.between(birthdate, currentdate).getYears();
        }
        else {
            return 0;
        }
    }
}