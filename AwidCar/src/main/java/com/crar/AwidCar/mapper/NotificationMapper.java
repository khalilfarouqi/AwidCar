package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);
    List<NotificationDto> toDto(List<Notification> NotificationList);
    Notification toEntity(NotificationDto notificationDto);
    List<Notification> toEntity(List<NotificationDto> notificationDtoList);
    Page<NotificationDto> toDto(Page<Notification> notificationPage);
}
