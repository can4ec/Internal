package com.experiments.internal.kafka;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListenerExample {

    private final Logger LOG = LogManager.getLogger(getClass());

    @KafkaListener(topics = "topic-1", groupId = "group1")
    public void listener(String data) {
        LOG.info("Received message [{}] in group1", data);
    }
}
