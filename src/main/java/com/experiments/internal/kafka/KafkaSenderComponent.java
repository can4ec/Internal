package com.experiments.internal.kafka;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class KafkaSenderComponent {

    private final Logger LOG = LogManager.getLogger(getClass());
    private final KafkaSender kafkaSender;

    @Autowired
    public KafkaSenderComponent(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostConstruct
    public void atStartup() {
        AtomicInteger counter = new AtomicInteger();
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> {
                    LOG.info("Message will be sent wit number: {}", counter.incrementAndGet());
                    kafkaSender.sendMessage("Message number is " + counter.get(), "topic-1");
                }, 0, 1, TimeUnit.SECONDS);
    }
}
