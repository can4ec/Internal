package com.experiments.internal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsController {

    @GetMapping("/hi")
    public String getHi() {
        return "I am cat!!!";
    }

}
