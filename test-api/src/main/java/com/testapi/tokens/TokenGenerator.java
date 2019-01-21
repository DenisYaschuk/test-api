package com.testapi.tokens;

import com.testapi.model.data.Account;
import com.testapi.model.data.Token;

public interface TokenGenerator {
    public Token generateToken(Account account);
}
