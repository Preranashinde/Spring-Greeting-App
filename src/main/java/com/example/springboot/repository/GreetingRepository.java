package com.example.springboot.repository;


import com.example.springboot.model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingRepository extends MongoRepository<Greeting, Integer> {
}
