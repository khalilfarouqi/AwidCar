package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.dto.NotificationDto;
import com.crar.AwidCar.entity.Notification;
import com.crar.AwidCar.rest.api.NotificationApi;
import com.crar.AwidCar.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NotificationController implements NotificationApi {
    private final NotificationService notificationService;
    @Override
    public NotificationDto save(NotificationDto notification) {
        return notificationService.save(notification);
    }

    @Override
    public NotificationDto update(NotificationDto notification) {
        return notificationService.update(notification);
    }

    @Override
    public void delete(Long id) {
        notificationService.delete(id);
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        return notificationService.findById(id);
    }

    @Override
    public List<NotificationDto> getAllNotification() {
        return notificationService.findAll();
    }

    @Override
    public Page<NotificationDto> search(String query, Integer page, Integer size, String order, String sort) {
        return notificationService.rsqlQuery(query, page, size, order, sort);
    }
}
