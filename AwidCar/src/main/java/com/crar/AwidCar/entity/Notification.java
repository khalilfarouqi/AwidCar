package com.crar.AwidCar.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String object;

    private String body;

    private Boolean isRead;

    private Boolean notificationWeb;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "notification_group_id")
    private NotificationGroup notificationGroup;
}
