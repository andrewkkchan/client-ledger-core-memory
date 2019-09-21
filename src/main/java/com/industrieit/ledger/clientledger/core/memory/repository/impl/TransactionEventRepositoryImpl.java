package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionEventRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TransactionEventRepositoryImpl implements TransactionEventRepository {
    @Override
    public Iterable<TransactionEvent> findAll() {
        return null;
    }

    @Override
    public Optional<TransactionEvent> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public TransactionEvent save(TransactionEvent transactionEvent) {
        return null;
    }
}
