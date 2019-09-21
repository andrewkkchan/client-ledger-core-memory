package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.Account;
import com.industrieit.ledger.clientledger.core.memory.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public Optional<Account> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public Iterable<Account> findAll() {
        return null;
    }
}
