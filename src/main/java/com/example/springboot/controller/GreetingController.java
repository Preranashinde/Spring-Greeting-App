package com.example.springboot.controller;


import com.example.springboot.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)

        public ResponseEntity sayWelcome() {
            return new ResponseEntity("Welcome to Greeting App", HttpStatus.OK);
        }
        @GetMapping(value = "/greeting/message", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity greetingMessage() {
            return new ResponseEntity(greetingAppService.greetingMessage(), HttpStatus.OK);
        }

    }