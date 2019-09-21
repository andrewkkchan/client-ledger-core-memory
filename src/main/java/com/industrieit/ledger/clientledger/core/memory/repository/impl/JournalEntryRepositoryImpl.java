package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;
import com.industrieit.ledger.clientledger.core.memory.repository.JournalEntryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JournalEntryRepositoryImpl implements JournalEntryRepository {
    private  final Map<String, JournalEntry> journalEntries = new HashMap<>();


    @Override
    public <S extends JournalEntry> Iterable<S> saveAll(Iterable<S> iterable) {
        for (JournalEntry journalEntry : iterable){
            journalEntries.put(journalEntry.getRequestId(), journalEntry);
        }
        return iterable;
    }

    @Override
    public Iterable<JournalEntry> findAllByRequestId(String requestId) {
        return journalEntries.values();
    }

    @Override
    public Iterable<JournalEntry> findAll() {
        return journalEntries.values();
    }
}
