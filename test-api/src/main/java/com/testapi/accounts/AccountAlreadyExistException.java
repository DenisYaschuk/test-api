package com.testapi.accounts;

import com.testapi.model.data.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AccountAlreadyExistException extends Exception {
	public AccountAlreadyExistException(Account account) {
		super("Account with login \"" + account.getLogin() + "\" already exist");
	}
}
