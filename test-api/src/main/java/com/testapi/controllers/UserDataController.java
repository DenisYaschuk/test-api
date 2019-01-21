package com.testapi.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.testapi.accounts.AccountNotFoundException;
import com.testapi.model.data.Account;
import com.testapi.model.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserDataController {
    private AccountsRepository repository;

    @Autowired
    public UserDataController(AccountsRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/data")
    @JsonView(Account.DATA.class)
    public Account getUserData(Principal principal) throws AccountNotFoundException {
        return repository.findById(principal.getName())
                .orElseThrow(AccountNotFoundException::new);
    }
}
