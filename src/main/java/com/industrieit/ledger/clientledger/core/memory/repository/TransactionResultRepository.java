package com.industrieit.ledger.clientledger.core.memory.repository;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;

import java.util.Optional;

public interface TransactionResultRepository {
    Optional<TransactionResult> findByRequestId(String requestId);

    Iterable<TransactionResult> findAll();

    TransactionResult save(TransactionResult transactionResult);
}
