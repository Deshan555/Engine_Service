package com.mongo.api.v01.controllers;

import com.mongo.api.v01.entity.MailTemplate;
import com.mongo.api.v01.json.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mongo.api.v01.servicesIMPL.Template_ServiceIMPL;

@RestController
@Slf4j
@RequestMapping("/api/engine/v01")
public class Template_Controller {
    private final Template_ServiceIMPL templateService;
    public Template_Controller(Template_ServiceIMPL templateService) {
        this.templateService = templateService;
    }
    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<Response> addTemplate(@RequestBody MailTemplate template) {
        try {
            templateService.addTemplate(template);
            return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Added Successfully", template), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Added Failed", null), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/look/id/{id}", produces = "application/json")
    public ResponseEntity<Response> getTemplateById(@PathVariable Integer id) {
        try {
            if(templateService.isTemplateExist(id)){
                MailTemplate mailTemplate = templateService.getTemplateByID(id.intValue());
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Found Successfully", mailTemplate), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found With Given ID", null), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found", null), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/look/name/{templateName}", produces = "application/json")
    public ResponseEntity<Response> lookTemplateByName(@PathVariable String templateName) {
        try {
            MailTemplate template = templateService.findTemplateByName(templateName);
            if(template != null){
                log.info("Template Found Successfully With Given Name : {}", templateName);
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Found Successfully", template), HttpStatus.OK);
            }log.info("Template Not Found With Given Name : {}", templateName);
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found With Given Name", null), HttpStatus.OK);
        } catch (Exception e) {
            log.info("Template Not Found With Given Name : {}", templateName);
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found", null), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<Response> getAllTemplates() {
        try {
            if(templateService.getAllTemplates().isEmpty()) {
                return new ResponseEntity<>(new Response(Response.ERROR, "No Templates Found (O - Templates Found)", null), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Fetch All Templates Successfully", templateService.getAllTemplates()), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(new Response(Response.ERROR, "Fetch All Templates Failed", null), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/all/{type}", produces = "application/json")
    public ResponseEntity<Response> getAllTemplatesByType(@PathVariable String type) {
        try {
            if(templateService.getAllTemplatesByType(type).isEmpty()) {
                return new ResponseEntity<>(new Response(Response.ERROR, "No Templates Found (O - Templates Found)", null), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Fetch All Templates Successfully", templateService.getAllTemplatesByType(type)), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(new Response(Response.ERROR, "Fetch All Templates Failed", null), HttpStatus.OK);
        }
    }
    @PutMapping(value = "/update/{templateID}", produces = "application/json")
    public ResponseEntity<Response> updateTemplateByID(@PathVariable Integer templateID, @RequestBody MailTemplate template) {
        try {
            if(templateService.isTemplateExist(templateID)){
                templateService.updateTemplate(template);
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Updated Successfully", template), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found With Given ID", null), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Error With Update Template", null), HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "/delete/{templateID}", produces = "application/json")
    public ResponseEntity<Response> deleteTemplateByID(@PathVariable Integer templateID) {
        try {
            if(templateService.isTemplateExist(templateID)){
                templateService.deleteTemplate(templateID);
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Deleted Successfully", null), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found With Given ID", null), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Error With Delete Template", null), HttpStatus.OK);
        }
    }
}
