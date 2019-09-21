package com.industrieit.ledger.clientledger.core.memory.consumer.impl;

import com.industrieit.ledger.clientledger.core.memory.consumer.Processor;
import com.industrieit.ledger.clientledger.core.memory.consumer.Producer;
import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.core.memory.model.ledger.Type;
import org.springframework.stereotype.Component;

@Component
public class BackUpProcessor implements Processor {
    private final Producer producer;


    public BackUpProcessor(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void process(TransactionEvent transactionEvent) {
        producer.produceSuccess(transactionEvent.getId(), null,
                transactionEvent.getKafkaPartition(), transactionEvent.getKafkaOffset());

    }

    @Override
    public String getType() {
        return Type.BACK_UP.toString();
    }
}
