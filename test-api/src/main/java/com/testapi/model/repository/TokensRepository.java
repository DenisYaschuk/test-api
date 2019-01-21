package com.testapi.model.repository;

import com.testapi.model.data.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokensRepository extends CrudRepository<Token, Long> {
}
