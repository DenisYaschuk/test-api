package com.testapi.tokens;

import com.testapi.model.data.Account;
import com.testapi.model.data.Token;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class MD5TokenGenerator implements TokenGenerator{
    @Override
    public Token generateToken(Account account) {
        try {
            return new Token(new BigInteger(MessageDigest.getInstance("MD5")
                    .digest(account.getLogin().concat(account.getPassword()).concat(LocalDateTime.now().toString()).getBytes())).longValue());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
