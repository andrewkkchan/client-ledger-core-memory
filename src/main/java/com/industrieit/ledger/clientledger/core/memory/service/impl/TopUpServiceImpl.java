package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.industrieit.ledger.clientledger.core.memory.ledger.committer.Committer;
import com.industrieit.ledger.clientledger.core.memory.ledger.validator.Validator;
import com.industrieit.ledger.clientledger.core.memory.model.ledger.Itemizable;
import com.industrieit.ledger.clientledger.core.memory.model.request.impl.TopUpRequest;
import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;
import com.industrieit.ledger.clientledger.core.memory.service.JournalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopUpServiceImpl implements JournalService<TopUpRequest> {
    private final Validator<TopUpRequest> validator;

    private final Committer committer;

    public TopUpServiceImpl(Validator<TopUpRequest> validator, Committer committer) {
        this.validator = validator;
        this.committer = committer;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Iterable<JournalEntry> journal(String requestId, TopUpRequest request, Integer kafkaPartition, Long kafkaOffset) {
        Itemizable itemizable = validator.validate(requestId, request);
        return committer.commit(itemizable.itemize(), kafkaPartition, kafkaOffset);
    }
}
