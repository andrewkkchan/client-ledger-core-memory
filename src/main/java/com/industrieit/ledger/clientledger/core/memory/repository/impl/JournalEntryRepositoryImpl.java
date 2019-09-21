package com.industrieit.ledger.clientledger.core.memory.repository.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;
import com.industrieit.ledger.clientledger.core.memory.repository.JournalEntryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JournalEntryRepositoryImpl implements JournalEntryRepository {
    private final List<JournalEntry> journalEntries = new ArrayList<>();


    @Override
    public <S extends JournalEntry> Iterable<S> saveAll(Iterable<S> iterable) {
        for (JournalEntry journalEntry : iterable) {
            journalEntries.add(journalEntry);
        }
        return iterable;
    }

    @Override
    public Iterable<JournalEntry> findAllByRequestId(String requestId) {
        List<JournalEntry> result = new ArrayList<>();
        for (JournalEntry journalEntry : journalEntries) {
            if (journalEntry.getRequestId().equals(requestId)) {
                result.add(journalEntry);
            }
        }
        return result;
    }

    @Override
    public Iterable<JournalEntry> findAll() {
        return journalEntries;
    }
}
