package com.chuadatten.user.entity;

import jakarta.persistence.*;
import lombok.*;
import com.chuadatten.user.common.Status;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_verifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInf user;

    @Column(name = "verification_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status verificationStatus;

    @Column(name = "face_id_url", length = 255)
    private String faceIdFrontUrl;

    @Column(name = "document_front_url", length = 255)
    private String documentFrontUrl;

    @Column(name = "document_back_url", length = 255)
    private String documentBackUrl;

    @Column
    private Integer version;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        this.verificationStatus= Status.PENDING;
    }
}
