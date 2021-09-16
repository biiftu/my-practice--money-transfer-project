package com.practice.moneytransferapp.repositories;

import com.practice.moneytransferapp.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.Long;

@Repository
public interface AccountRepository extends CrudRepository <Account, Long> {}