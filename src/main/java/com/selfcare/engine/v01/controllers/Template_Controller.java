package com.selfcare.engine.v01.controllers;

import com.selfcare.engine.v01.entity.Template;
import com.selfcare.engine.v01.json.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.selfcare.engine.v01.servicesIMPL.Template_ServiceIMPL;

@Tag(name = "Tutorial", description = "Tutorial management APIs")
@RestController
@Slf4j
@RequestMapping("/api/engine/v01")
public class Template_Controller {
    private final Template_ServiceIMPL templateService;
    public Template_Controller(Template_ServiceIMPL templateService) {
        this.templateService = templateService;
    }

    @Operation(summary = "Create New Template",
            tags = {"POST"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                    @Content(schema = @Schema(implementation = Template.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<Response> addTemplate(@RequestBody Template template) {
        try {
            templateService.addTemplate(template);
            return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Added Successfully", template), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Added Failed", null), HttpStatus.OK);
        }
    }

    @Operation(summary = "Get Template By ID",
            tags = {"GET"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/look/id/{id}", produces = "application/json")
    public ResponseEntity<Response> getTemplateById(@PathVariable Integer id) {
        try {
            if(templateService.isTemplateExist(id)){
                Template template = templateService.getTemplateByID(id.intValue());
                return new ResponseEntity<>(new Response(Response.SUCCESS, "Template Found Successfully", template), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found With Given ID", null), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(Response.ERROR, "Template Not Found", null), HttpStatus.OK);
        }
    }

    @Operation(summary = "Get Template Filter By Template Name",
            tags = {"GET"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/look/name/{templateName}", produces = "application/json")
    public ResponseEntity<Response> lookTemplateByName(@PathVariable String templateName) {
        try {
            Template template = templateService.findTemplateByName(templateName);
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

    @Operation(summary = "Get All Templates",
            tags = {"GET"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
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

    @Operation(summary = "Get All Templates Filter By Type",
            tags = {"GET"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
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

    @Operation(summary = "Update Template By ID",
            tags = {"PUT"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(value = "/update/{templateID}", produces = "application/json")
    public ResponseEntity<Response> updateTemplateByID(@PathVariable Integer templateID, @RequestBody Template template) {
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

    @Operation(summary = "Delete Template By ID",
            tags = {"DELETE"})
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {
                            @Content(schema = @Schema(implementation = Template.class),
                                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
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
