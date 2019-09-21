package com.industrieit.ledger.clientledger.core.memory.model.request.impl;

import com.industrieit.ledger.clientledger.core.memory.model.request.EventRequest;

public class SnapshotRequest implements EventRequest {
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public SnapshotRequest(String accountId) {
        this.accountId = accountId;
    }

    public SnapshotRequest() {
    }
}
