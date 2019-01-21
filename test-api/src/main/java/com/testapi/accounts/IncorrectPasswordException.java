package com.testapi.accounts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) //TODO: Correct status
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
        super("Password is incorrect");
    }
}
