package com.crar.AwidCar.dto;

import com.crar.AwidCar.entity.enums.NotificationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationGroupDto {
    private Long id;
    private String object;
    private String body;
    private NotificationType notificationType;
    private Boolean notificationWeb;
    private Date dateEnvoi;
}
