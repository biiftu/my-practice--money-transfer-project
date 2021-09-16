package com.practice.moneytransferapp.unittest;

import com.practice.moneytransferapp.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepository_UT {

    @MockBean //we mock it when using unit test
    private AccountRepository accountRepository;

    @Before
    public void shouldReturnTheCountOfAccounts(){
        given(accountRepository.count())
                .willReturn(6L);
    }

    @Test
    public void toConfirm(){
        long theCount = accountRepository.count();
        assertThat(theCount).isEqualTo(6L);
    }
}
