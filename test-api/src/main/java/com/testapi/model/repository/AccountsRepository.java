package com.testapi.model.repository;

import com.testapi.model.data.Account;
import com.testapi.model.data.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountsRepository extends CrudRepository<Account, String> {
    Optional<Account> findByToken(Token token);
}
