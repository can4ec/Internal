package com.experiments.internal.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaSender {

    private final Logger LOG = LogManager.getLogger(getClass());
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message, String topic) {
        try {
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
            future.thenApply(result -> {
                LOG.info("Sent message=[{}] with offset=[{}]", result.getProducerRecord().value(), result.getRecordMetadata().offset());
                return null;
            }).exceptionally(ex -> {
                LOG.warn("Unable to send message due to ", ex);
                return null;
            });
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            LOG.error(e);
        }
    }
}
