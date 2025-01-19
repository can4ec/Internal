package com.experiments.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class InternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalApplication.class, args);
	}

}
