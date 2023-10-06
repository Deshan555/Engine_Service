package com.selfcare.engine.v01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("com.mongo.api.v01.entity")
@EnableMongoRepositories("com.mongo.api.v01.repositories")
public class MongoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoApiApplication.class, args);
    }

}
