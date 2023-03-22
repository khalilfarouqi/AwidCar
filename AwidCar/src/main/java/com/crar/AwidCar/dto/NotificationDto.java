package com.crar.AwidCar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDto {
    private Long id;
    private String object;
    private String body;
    private Boolean isRead;
    private Boolean notificationWeb;
    private UserDto userDto;
    private NotificationGroupDto notificationGroupDto;
}
