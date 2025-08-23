package com.chuadatten.transaction.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Document(collection = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    private String id ; 
    @Field("user_id")
    private String userId;

    @Field("action")
    private String action;

    @Field("description")
    private String description;

    @CreatedDate
    @Field("created_at")
    private Instant createdAt;
}
