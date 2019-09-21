package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.industrieit.ledger.clientledger.core.memory.model.request.impl.SnapshotRequest;
import com.industrieit.ledger.clientledger.core.memory.service.SnapshotService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SnapshotServiceImpl implements SnapshotService {

    public SnapshotServiceImpl() {

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public long snapshot(SnapshotRequest snapshotRequest) {
        return new Date().getTime();
    }
}
