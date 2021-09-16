package com.practice.moneytransferapp.integrationtest;

import com.practice.moneytransferapp.domains.Account;
import com.practice.moneytransferapp.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
public class AccountRepository_IT {
    @Autowired // We Autowire when using integration test
    AccountRepository accountRepository;

    @Test
    public void shouldReturnFromDatabase(){
        Account account = Account.builder()
                .first_name("Sara")
                .middle_name("Gashaw")
                .last_name("GebreTsadik")
                .birth_date(LocalDate.of(2000, 9, 30))
                .email("sarahsati@email.com")
                .phone_number("0987664434")
                .pin(1122)
                .build();

        Account saved = accountRepository.save(account);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(2);

        assertThat(saved.getFirst_name()).isEqualTo("Sara");
        assertThat(saved.getFirst_name()).isEqualTo(account.getFirst_name());
    }
}
