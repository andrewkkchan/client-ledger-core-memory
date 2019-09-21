package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionResultRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TransactionResultRepositoryImpl implements TransactionResultRepository {
    private final Map<String, TransactionResult> transactionResults = new HashMap<>();
    @Override
    public Optional<TransactionResult> findByRequestId(String requestId) {
        return Optional.ofNullable(transactionResults.get(requestId));
    }

    @Override
    public Iterable<TransactionResult> findAll() {
        return transactionResults.values();
    }

    @Override
    public TransactionResult save(TransactionResult transactionResult) {
        transactionResults.put(transactionResult.getRequestId(), transactionResult);
        return transactionResult;
    }
}
