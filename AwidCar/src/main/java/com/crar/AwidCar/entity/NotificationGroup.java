package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="NotificationGroups")
public class NotificationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String object;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String body;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private Boolean notificationWeb;

    private Date dateEnvoy;
}
