package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionResultRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TransactionResultRepositoryImpl implements TransactionResultRepository {
    @Override
    public Optional<TransactionResult> findByRequestId(String requestId) {
        return Optional.empty();
    }

    @Override
    public Iterable<TransactionResult> findAll() {
        return null;
    }

    @Override
    public TransactionResult save(TransactionResult transactionResult) {
        return null;
    }
}
