package com.selfcare.engine.v01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("mailTemplates")
public class Template {
    @Id
    private Long id;
    private String templateName;
    private String subject;
    private String body;
    private String templateType;
    private LocalDateTime createdDate;
}