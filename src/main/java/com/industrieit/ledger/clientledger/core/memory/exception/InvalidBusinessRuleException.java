package com.industrieit.ledger.clientledger.core.memory.exception;

import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;

/**
 * Run Time Exception thrown during processing of one {@link TransactionEvent}
 */
public class InvalidBusinessRuleException extends RuntimeException {
    public InvalidBusinessRuleException(String message) {
        super(message);
    }
}
