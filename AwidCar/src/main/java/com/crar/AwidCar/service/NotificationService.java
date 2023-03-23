package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.NotificationDto;
import com.crar.AwidCar.entity.Notification;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.mapper.NotificationGroupMapper;
import com.crar.AwidCar.mapper.NotificationMapper;
import com.crar.AwidCar.repository.NotificationRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class NotificationService implements IBaseService<Notification, NotificationDto> {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper = Mappers.getMapper(NotificationMapper.class);
    @Override
    @Transactional
    public NotificationDto save(NotificationDto notification) {
        return notificationMapper.toDto(notificationRepository.save(notificationMapper.toEntity(notification)));
    }

    @Override
    @Transactional
    public NotificationDto update(NotificationDto notification) {
        if (findById(notification.getId()).equals(null))
            throw new ResourceNotFoundException("notification not fond");
        return notificationMapper.toDto(notificationRepository.save(notificationMapper.toEntity(notification)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public NotificationDto findById(Long id) {
        return notificationMapper.toDto(notificationRepository.findById(id).get());
    }

    @Override
    public List<NotificationDto> findAll() {
        return notificationMapper.toDto(notificationRepository.findAll());
    }

    @Override
    public Page<NotificationDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return notificationMapper.toDto(notificationRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
