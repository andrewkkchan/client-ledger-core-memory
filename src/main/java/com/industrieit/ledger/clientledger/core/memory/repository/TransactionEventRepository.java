package com.industrieit.ledger.clientledger.core.memory.repository;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;

import java.util.Optional;

public interface TransactionEventRepository  {
    Iterable<TransactionEvent> findAll();

    Optional<TransactionEvent> findById(String id);

    boolean existsById(String id);

    TransactionEvent save(TransactionEvent transactionEvent);
}
