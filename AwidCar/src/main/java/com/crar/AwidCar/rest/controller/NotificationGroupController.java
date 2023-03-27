package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.dto.NotificationGroupDto;
import com.crar.AwidCar.entity.Roles;
import com.crar.AwidCar.rest.api.NotificationGroupApi;
import com.crar.AwidCar.service.NotificationGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RolesAllowed({Roles.admin, Roles.client})
public class NotificationGroupController implements NotificationGroupApi {
    private final NotificationGroupService notificationGroupService;
    @Override
    public NotificationGroupDto save(NotificationGroupDto notificationGroup) {
        return notificationGroupService.save(notificationGroup);
    }

    @Override
    public NotificationGroupDto update(NotificationGroupDto notificationGroup) {
        return notificationGroupService.update(notificationGroup);
    }

    @Override
    public void delete(Long id) {
        notificationGroupService.delete(id);
    }

    @Override
    public NotificationGroupDto getNotificationGroupById(Long id) {
        return notificationGroupService.findById(id);
    }

    @Override
    public List<NotificationGroupDto> getAllNotificationGroup() {
        return notificationGroupService.findAll();
    }

    @Override
    public Page<NotificationGroupDto> search(String query, Integer page, Integer size, String order, String sort) {
        return notificationGroupService.rsqlQuery(query, page, size, order, sort);
    }
}
