package com.mongo.api.v01.services;

import com.mongo.api.v01.entity.MailTemplate;
import com.mongo.api.v01.repositories.templateRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Slf4j
public class templateService {
    private final templateRepo templateRepository;
    public templateService(templateRepo templateRepository) {
        this.templateRepository = templateRepository;
    }
    public MailTemplate addTemplate(MailTemplate template){
        try{
            template.setId(getLatestId()+1);
            template.setCreatedDate(LocalDateTime.now());
            templateRepository.save(template);
        } catch (Exception Error) {
            log.info("Exception = " + Error);
            return null;
        }
        return template;
    }
    @Cacheable("latestId")
    public Long getLatestId(){
        try{
            return (Long) templateRepository.count();
        } catch (Exception error) {
            log.info("Exception = " + error);
            return 0L;
        }
    }
    // TODO : add custom exceptions
    @Cacheable("template")
    public MailTemplate getTemplateByID(Integer id) {
        System.out.println("Getting item by id: " + id);
        try{
            MailTemplate template = templateRepository.findById(id).get();
            log.info("Template = " + template);
            return template;
        }catch (Exception Error){
            log.info("Exception = " + Error);
            return null;
        }
    }
}
