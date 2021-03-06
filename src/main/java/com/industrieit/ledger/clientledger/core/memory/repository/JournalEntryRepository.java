package com.industrieit.ledger.clientledger.core.memory.repository;


import com.industrieit.ledger.clientledger.core.memory.entity.JournalEntry;


public interface JournalEntryRepository {

    <S extends JournalEntry> Iterable<S> saveAll(Iterable<S> iterable);

    Iterable<JournalEntry> findAllByRequestId(String requestId);

    Iterable<JournalEntry> findAll();
}
