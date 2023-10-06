package com.selfcare.engine.v01.repositories;

import com.selfcare.engine.v01.entity.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface templateRepo extends MongoRepository<Template, Integer>{
    @Query("{templateName:'?0'}")
    Template findItemByName(String name);
    @Query(value="{templateType:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Template> findAll(String category);
    @Query("{templateType:'?0'}")
    List<Template> findItemByType(String templateType);
    public long count();
    boolean existsById(Integer id);
}