package com.industrieit.ledger.clientledger.core.memory.consumer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.industrieit.ledger.clientledger.core.memory.consumer.Producer;
import com.industrieit.ledger.clientledger.core.memory.entity.TransactionResult;
import com.industrieit.ledger.clientledger.core.memory.exception.InvalidBusinessRuleException;
import com.industrieit.ledger.clientledger.core.memory.repository.TransactionResultRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class ProducerImpl implements Producer {
    private final TransactionResultRepository transactionResultRepository;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, TransactionResult> kafkaTemplate;
    private static final String TOPIC = "Transaction_Result_Memory";



    public ProducerImpl(TransactionResultRepository transactionResultRepository, ObjectMapper objectMapper,
                        KafkaTemplate<String, TransactionResult> kafkaTemplate) {
        this.transactionResultRepository = transactionResultRepository;
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceError(String requestId, InvalidBusinessRuleException e, Integer kafkaPartition, long kafkaOffset) {
        TransactionResult transactionResult = new TransactionResult();
        transactionResult.setRequestId(requestId);
        if (e != null) {
            transactionResult.setResponse("{\"message\": \"" + e.getMessage() + "\"}");
        } else {
            transactionResult.setResponse("{\"message\": null}");
        }
        transactionResult.setSuccess(false);
        transactionResult.setKafkaPartition(kafkaPartition);
        transactionResult.setKafkaOffset(kafkaOffset);
        TransactionResult save = transactionResultRepository.save(transactionResult);
        kafkaTemplate.send(TOPIC, save);

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public <T> void produceSuccess(String requestId, T response, Integer kafkaPartition, long kafkaOffset) {
        TransactionResult transactionResult = new TransactionResult();
        transactionResult.setRequestId(requestId);
        try {
            transactionResult.setResponse(objectMapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            transactionResult.setResponse("{}");
        }
        transactionResult.setSuccess(true);
        transactionResult.setKafkaPartition(kafkaPartition);
        transactionResult.setKafkaOffset(kafkaOffset);
        TransactionResult save = transactionResultRepository.save(transactionResult);
        save.setCreateTime(new Date().getTime());
        kafkaTemplate.send(TOPIC, save);
    }
}
