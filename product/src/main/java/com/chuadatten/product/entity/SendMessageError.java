package com.chuadatten.product.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.Instant;

@Document(collection = "send_message_error")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendMessageError {

    @Id
    private String id; // Có thể generate thủ công String.randomUUID() khi tạo document

    @Field("topic")
    private String topic;

    @Field("message")
    private String message;

    @Field("status")
    private String status;

    @CreatedDate
    @Field("created_at")
    private Instant createdAt;
}
