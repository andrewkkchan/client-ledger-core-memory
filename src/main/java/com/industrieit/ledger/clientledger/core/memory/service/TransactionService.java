package com.industrieit.ledger.clientledger.core.memory.service;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;

public interface TransactionService {
    TransactionResult getLastResult();

}
