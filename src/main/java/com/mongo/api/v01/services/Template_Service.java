package com.mongo.api.v01.services;

import com.mongo.api.v01.entity.MailTemplate;

import java.util.List;

public interface Template_Service {
    MailTemplate addTemplate(MailTemplate template);
    Long getLatestId();
    MailTemplate updateTemplate(MailTemplate template);
    MailTemplate getTemplateByID(Integer id);
    MailTemplate findTemplateByName(String templateName);

    boolean isTemplateExist(Integer id);
    List<MailTemplate> getAllTemplatesByType(String type);
    void deleteTemplate(Integer id);
    void deleteAllTemplates();
    List<MailTemplate> getAllTemplates();
}
