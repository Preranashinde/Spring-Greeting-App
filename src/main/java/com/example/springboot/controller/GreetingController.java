package com.example.springboot.controller;


import com.example.springboot.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     @GetMapping(value = "/greeting/message/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessageWithName(@PathVariable("name") String name) {
        return new ResponseEntity(greetingAppService.greetingMessage(name), HttpStatus.OK);
    }

    @GetMapping(value = "/greeting/message/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greetingMessageWithName(@PathVariable("id") int id) {
        return new ResponseEntity(greetingAppService.findGreetingMessage(id), HttpStatus.OK);
    }

    }