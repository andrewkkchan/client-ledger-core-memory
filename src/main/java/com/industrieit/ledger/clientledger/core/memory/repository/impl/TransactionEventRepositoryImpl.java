package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionEventRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TransactionEventRepositoryImpl implements TransactionEventRepository {
    private final Map<String, TransactionEvent> transactionEvents = new HashMap<>();
    @Override
    public Iterable<TransactionEvent> findAll() {
        return transactionEvents.values();
    }

    @Override
    public Optional<TransactionEvent> findById(String id) {
        return Optional.ofNullable(transactionEvents.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return transactionEvents.containsKey(id);
    }

    @Override
    public TransactionEvent save(TransactionEvent transactionEvent) {
        transactionEvents.put(transactionEvent.getId(), transactionEvent);
        return transactionEvent;
    }
}
