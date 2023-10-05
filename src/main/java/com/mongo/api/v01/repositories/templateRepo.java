package com.mongo.api.v01.repositories;

import com.mongo.api.v01.entity.MailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface templateRepo extends MongoRepository<MailTemplate, String>{
    @Query("{templateName:'?0'}")
    MailTemplate findItemByName(String name);
    @Query(value="{templateType:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<MailTemplate> findAll(String category);
    public long count();

}