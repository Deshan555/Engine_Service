package com.mongo.api.v01.services;

import com.mongo.api.v01.entity.Template;

import java.util.List;

public interface Template_Service {
    Template addTemplate(Template template);
    Long getLatestId();
    Template updateTemplate(Template template);
    Template getTemplateByID(Integer id);
    Template findTemplateByName(String templateName);

    boolean isTemplateExist(Integer id);
    List<Template> getAllTemplatesByType(String type);
    void deleteTemplate(Integer id);
    void deleteAllTemplates();
    List<Template> getAllTemplates();
}
