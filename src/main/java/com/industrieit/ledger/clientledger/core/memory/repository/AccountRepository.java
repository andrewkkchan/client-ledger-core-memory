package com.industrieit.ledger.clientledger.core.memory.repository;

import com.industrieit.ledger.clientledger.core.memory.entity.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(String s);

    Account save(Account account);

    boolean existsById(String id);

    Iterable<Account> findAll();

}
