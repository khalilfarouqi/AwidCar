package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.NotificationGroup;
import com.crar.AwidCar.rest.api.NotificationGroupApi;
import com.crar.AwidCar.service.NotificationGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NotificationGroupController implements NotificationGroupApi {
    private final NotificationGroupService notificationGroupService;
    @Override
    public NotificationGroup save(NotificationGroup notificationGroup) {
        return notificationGroupService.save(notificationGroup);
    }

    @Override
    public NotificationGroup update(NotificationGroup notificationGroup) {
        return notificationGroupService.update(notificationGroup);
    }

    @Override
    public void delete(Long id) {
        notificationGroupService.delete(id);
    }

    @Override
    public NotificationGroup getNotificationGroupById(Long id) {
        return notificationGroupService.findById(id);
    }

    @Override
    public List<NotificationGroup> getAllNotificationGroup() {
        return notificationGroupService.findAll();
    }

    @Override
    public Page<NotificationGroup> search(String query, Integer page, Integer size, String order, String sort) {
        return notificationGroupService.rsqlQuery(query, page, size, order, sort);
    }
}
