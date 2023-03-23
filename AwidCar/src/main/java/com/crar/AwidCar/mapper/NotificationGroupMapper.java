package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationGroupMapper {
    NotificationGroupDto toDto(NotificationGroup notificationGroup);
    List<NotificationGroupDto> toDto(List<NotificationGroup> notificationGroupList);
    NotificationGroup toEntity(NotificationGroupDto notificationGroupDto);
    List<NotificationGroup> toEntity(List<NotificationGroupDto> notificationGroupDtoList);
    Page<NotificationGroupDto> toDto(Page<NotificationGroup> notificationGroupPage);
}
