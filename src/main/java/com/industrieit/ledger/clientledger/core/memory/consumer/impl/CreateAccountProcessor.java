package com.industrieit.ledger.clientledger.core.memory.consumer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.industrieit.ledger.clientledger.core.memory.consumer.Processor;
import com.industrieit.ledger.clientledger.core.memory.consumer.Producer;

import com.industrieit.ledger.clientledger.core.memory.entity.Account;
import com.industrieit.ledger.clientledger.core.memory.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.core.memory.exception.InvalidBusinessRuleException;
import com.industrieit.ledger.clientledger.core.memory.model.ledger.Type;
import com.industrieit.ledger.clientledger.core.memory.model.request.impl.CreateAccountRequest;
import com.industrieit.ledger.clientledger.core.memory.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
public class CreateAccountProcessor implements Processor {
    private final ObjectMapper objectMapper;
    private final AccountService accountService;
    private final Producer producer;


    public CreateAccountProcessor(ObjectMapper objectMapper, AccountService accountService, Producer producer) {
        this.objectMapper = objectMapper;
        this.accountService = accountService;
        this.producer = producer;
    }

    public void process(TransactionEvent transactionEvent) {
        String requestId = transactionEvent.getId();

        CreateAccountRequest createAccountRequest;
        try {
            createAccountRequest = objectMapper.readValue(transactionEvent.getRequest(), CreateAccountRequest.class);
        } catch (IOException e) {
            producer.produceError(requestId, new InvalidBusinessRuleException("Malformed request"),
                    transactionEvent.getKafkaPartition(), transactionEvent.getKafkaOffset());
            return;
        }
        try {
            createAccountAndProduce(requestId, createAccountRequest, transactionEvent.getKafkaPartition(), transactionEvent.getKafkaOffset());
        } catch (InvalidBusinessRuleException e) {
            producer.produceError(requestId, e, transactionEvent.getKafkaPartition(), transactionEvent.getKafkaOffset());
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createAccountAndProduce(String requestId, CreateAccountRequest createAccountRequest, Integer kafkaPartition, long kafkaOffset) {
        Account account = this.accountService.createAccount(createAccountRequest);
        producer.produceSuccess(requestId, account, kafkaPartition, kafkaOffset);
    }

    @Override
    public String getType() {
        return Type.CREATE_ACCOUNT.toString();
    }
}
