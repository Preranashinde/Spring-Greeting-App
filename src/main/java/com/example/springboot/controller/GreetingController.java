package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessage() {
        return new ResponseEntity("Welcome to Greeting App", HttpStatus.OK);
    }
}