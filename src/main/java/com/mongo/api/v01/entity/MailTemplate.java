package com.mongo.api.v01.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Document("mailTemplates")
public class MailTemplate {
    @Id
    private int id;
    private String templateName;
    private String subject;
    private String body;
    private String templateType;
    private LocalDateTime createdDate;
    public MailTemplate(int id, String name, String subject, String body, String templateType, LocalDateTime createdDate) {
        super();
        this.id = id;
        this.templateName = name;
        this.subject = subject;
        this.body = body;
        this.templateType = templateType;
        this.createdDate = createdDate;
    }
}

/*
@Document("templates")
public class GroceryItem {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

    public GroceryItem(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
 */