package com.selfcare.engine.v01.servicesIMPL;

import com.selfcare.engine.v01.entity.Template;
import com.selfcare.engine.v01.repositories.templateRepo;
import com.selfcare.engine.v01.services.Template_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class Template_ServiceIMPL implements Template_Service {
    private final templateRepo templateRepository;
    public Template_ServiceIMPL(templateRepo templateRepository) {
        this.templateRepository = templateRepository;
    }
    @Override
    public Template addTemplate(Template template){
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
    @Override
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
    @Override
    @Cacheable("template")
    public Template getTemplateByID(Integer id) {
        try{
            Template template = templateRepository.findById(id).get();
            log.info("Template = " + template);
            return template;
        }catch (Exception Error){
            log.info("Exception = " + Error);
            return null;
        }
    }
    @Override
    public boolean isTemplateExist(Integer id) {
        return templateRepository.existsById(id);
    }
    @Override
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }
    @Override
    public List<Template> getAllTemplatesByType(String type) {
        return templateRepository.findItemByType(type);
    }
    @Override
    public void deleteTemplate(Integer id) {
        templateRepository.deleteById(id);
    }
    @Override
    @Cacheable("template_name")
    public Template findTemplateByName(String name) {
        return templateRepository.findItemByName(name);
    }
    @Override
    public Template updateTemplate(Template template) {
        try{
            template.setCreatedDate(LocalDateTime.now());
            templateRepository.save(template);
            log.info("Template Updated Successfully : {}", template);
            return template;
        } catch (Exception Error) {
            log.info("Exception = " + Error);
            return null;
        }
    }
    @Override
    public void deleteAllTemplates() {
        templateRepository.deleteAll();
    }

}
