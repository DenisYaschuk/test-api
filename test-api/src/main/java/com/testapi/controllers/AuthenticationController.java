package com.testapi.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.testapi.accounts.AccountAlreadyExistException;
import com.testapi.model.data.Account;
import com.testapi.model.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	private AccountsRepository repository;

	@Autowired
	public AuthenticationController(AccountsRepository repository) {
		this.repository = repository;
	}


	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Account.CREDITIONALS.class)
	public Account register (@RequestBody Account account) throws AccountAlreadyExistException {
//		if (isNull(account.getLogin()) || isNull(account.getFirstName()) || isNull(account.getLastName()) || isNull(account.getPassword()))
//			throw new IllegalArgumentException("All data must be not null.");

		if (repository.existsById(account.getLogin()))
			throw new AccountAlreadyExistException(account);

		return repository.save(account);
	}
}
