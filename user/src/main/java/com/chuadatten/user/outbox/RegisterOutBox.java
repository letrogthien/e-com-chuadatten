package com.chuadatten.user.outbox;

import com.chuadatten.user.common.Status;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Builder
@Document("register_outbox")
public class RegisterOutBox {
    @Id
    private String id;
    private String email;
    private UUID userId;
    private String urlActivation;
    private Status status;
    private LocalDateTime createdAt;
}
