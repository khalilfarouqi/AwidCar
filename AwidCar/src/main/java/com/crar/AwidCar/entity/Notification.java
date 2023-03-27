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

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String body;

    private Boolean isRead;

    private Boolean notificationWeb;

    @ManyToOne
    private User user;

    @OneToOne
    private NotificationGroup notificationGroup;
}
