package com.experiments.internal.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Arrays;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PetApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test-profile");
        SpringApplication.run(PetApplication.class, args);
    }

}
