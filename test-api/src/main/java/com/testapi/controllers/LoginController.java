package com.testapi.controllers;

import com.testapi.accounts.AccountNotFoundException;
import com.testapi.accounts.IncorrectPasswordException;
import com.testapi.model.data.Account;
import com.testapi.model.data.Token;
import com.testapi.model.repository.AccountsRepository;
import com.testapi.model.repository.TokensRepository;
import com.testapi.tokens.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private TokenGenerator generator;

    private AccountsRepository accountsRepository;

    private TokensRepository tokensRepository;

    @Autowired
    public LoginController(TokenGenerator generator, AccountsRepository accountsRepository, TokensRepository tokensRepository) {
        this.generator = generator;
        this.accountsRepository = accountsRepository;
        this.tokensRepository = tokensRepository;
    }


    @PostMapping("/login")
    public Token getToken(@RequestBody Account account) throws AccountNotFoundException, IncorrectPasswordException {
        String password = accountsRepository.findById(account.getLogin())
                .orElseThrow(AccountNotFoundException::new)
                .getPassword();

        if (!password.equals(account.getPassword()))
            throw new IncorrectPasswordException();

        if (account.getToken() != null)
            tokensRepository.delete(account.getToken());

        Token token = tokensRepository.save(generator.generateToken(account));

        account.setToken(token);
        accountsRepository.save(account);

        return token;
    }
}
