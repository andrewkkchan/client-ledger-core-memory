package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.Account;
import com.industrieit.ledger.clientledger.core.memory.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final Map<String, Account> accounts = new HashMap<>();
    @Override
    public Optional<Account> findById(String s) {
        return Optional.ofNullable(accounts.get(s));
    }

    @Override
    public Account save(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public boolean existsById(String id) {
        return accounts.containsKey(id);
    }

    @Override
    public Iterable<Account> findAll() {
        return accounts.values();
    }
}
