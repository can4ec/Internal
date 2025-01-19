package com.experiments.internal.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties("demo.kafka")
public class KafkaProperties {

    private final String bootstrapServers;

    @ConstructorBinding
    public KafkaProperties(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }
}
