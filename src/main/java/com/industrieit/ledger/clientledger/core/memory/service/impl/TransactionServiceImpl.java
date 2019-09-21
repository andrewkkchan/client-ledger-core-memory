package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionResultRepository;
import com.industrieit.ledger.clientledger.core.memory.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionResultRepository transactionResultRepository;

    public TransactionServiceImpl(TransactionResultRepository transactionResultRepository) {
        this.transactionResultRepository = transactionResultRepository;
    }

    public TransactionResult getLastResult(){
        Iterable<TransactionResult> all = transactionResultRepository.findAll();
        if (Iterables.isEmpty(all)){
            return null;
        }
        return Collections.max(Lists.newArrayList(all), (o1, o2) -> {
            long diff = o1.getKafkaOffset() - o2.getKafkaOffset();
            if (diff > 0) {
                return 1;
            }
            if (diff == 0) {
                return 0;
            }
            return -1;
        });
    }
}
