package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.industrieit.ledger.clientledger.core.memory.ledger.committer.Committer;
import com.industrieit.ledger.clientledger.core.memory.ledger.validator.Validator;
import com.industrieit.ledger.clientledger.core.memory.model.ledger.Itemizable;
import com.industrieit.ledger.clientledger.core.memory.model.request.impl.P2PRequest;
import com.industrieit.ledger.clientledger.core.memory.service.JournalService;
import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class P2PServiceImpl implements JournalService<P2PRequest> {
    private final Validator<P2PRequest> validator;
    private final Committer committer;

    public P2PServiceImpl(Validator<P2PRequest> validator, Committer committer) {
        this.validator = validator;
        this.committer = committer;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Iterable<JournalEntry> journal(String requestId, P2PRequest request, Integer kafkaPartition, Long kafkaOffset) {
        Itemizable itemizable = validator.validate(requestId, request);
        return committer.commit(itemizable.itemize(), kafkaPartition, kafkaOffset);
    }

}
