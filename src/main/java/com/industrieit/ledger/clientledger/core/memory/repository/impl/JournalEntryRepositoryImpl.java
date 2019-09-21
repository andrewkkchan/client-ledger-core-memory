package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;
import com.industrieit.ledger.clientledger.core.memory.repository.JournalEntryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JournalEntryRepositoryImpl implements JournalEntryRepository {
    @Override
    public Iterable<JournalEntry> findAllByAccountId(String accountId) {
        return null;
    }

    @Override
    public <S extends JournalEntry> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Iterable<JournalEntry> findAllByRequestId(String requestId) {
        return null;
    }

    @Override
    public Iterable<JournalEntry> findAll() {
        return null;
    }
}
