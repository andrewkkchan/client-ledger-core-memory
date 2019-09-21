package com.industrieit.ledger.clientledger.core.memory.entity;

import com.industrieit.ledger.clientledger.core.memory.consumer.Processor;
import com.industrieit.ledger.clientledger.core.memory.consumer.Producer;

import java.util.Date;

/**
 * Entity which is produced by {@link Producer} for exactly one {@link TransactionEvent} after consumption
 * Represents the result of processing of {@link TransactionEvent} by the {@link Processor}
 * Can be either success or failure.
 * In both cases, more info are available and packed into the Event.
 */
public class TransactionResult {

    private String id;
    private String requestId;
    private String response;
    private long createTime = new Date().getTime();
    private boolean success;
    private long kafkaOffset;
    private Integer kafkaPartition;

    /**
     * @return id, for database key, not particularly useful
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return response which is usually a well-formed JSON string representing the result of processing of {@link TransactionEvent}
     */
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return request event id which originates this result
     */
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return create time. Form the sequence of the result queue.
     * the order shall be 100% identical with the order of the {@link TransactionEvent} queue
     */
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return whether the processing of {@link TransactionEvent} is successful or not.
     */
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getKafkaOffset() {
        return kafkaOffset;
    }

    public void setKafkaOffset(long kafkaOffset) {
        this.kafkaOffset = kafkaOffset;
    }

    public Integer getKafkaPartition() {
        return kafkaPartition;
    }

    public void setKafkaPartition(Integer kafkaPartition) {
        this.kafkaPartition = kafkaPartition;
    }
}
