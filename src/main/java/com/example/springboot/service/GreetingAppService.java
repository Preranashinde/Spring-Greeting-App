package com.example.springboot.service;

import com.example.springboot.model.Greeting;
import com.example.springboot.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GreetingAppService {
    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    private GreetingRepository greetingRepository;

    public String greetingMessage() {
        return "Hello World";
    }

    public String greetingMessage(String name) {
        String message = "Hello " + name;
        Greeting greeting = new Greeting((int) (greetingRepository.count() + 1), name, message);
        greetingRepository.save(greeting);
        return message;
    }

    public Optional<Greeting> findGreetingMessage(int id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> listAllGreetingMessage() {
        return greetingRepository.findAll();
    }
    public Optional<Greeting> updateGreetingMessage(Greeting greeting, int id) {
        Optional<Greeting> greetingObject = greetingRepository.findById(id);
        greetingObject.get().setMessage(greeting.getMessage());
        greetingRepository.save(greetingObject.get());
        return greetingObject;
    }
}

