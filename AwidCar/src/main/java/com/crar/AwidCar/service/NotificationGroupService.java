package com.crar.AwidCar.service;

import com.crar.AwidCar.entity.NotificationGroup;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.repository.NotificationGroupRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class NotificationGroupService implements IBaseService<NotificationGroup> {
    private final NotificationGroupRepository notificationGroupRepository;

    @Override
    @Transactional
    public NotificationGroup save(NotificationGroup notificationGroup) {
        return notificationGroupRepository.save(notificationGroup);
    }

    @Override
    @Transactional
    public NotificationGroup update(NotificationGroup notificationGroup) {
        if (findById(notificationGroup.getId()).equals(null))
            throw new ResourceNotFoundException("Notification Group not fond");
        return notificationGroupRepository.save(notificationGroup);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        notificationGroupRepository.deleteById(id);
    }

    @Override
    public NotificationGroup findById(Long id) {
        return notificationGroupRepository.findById(id).get();
    }

    @Override
    public List<NotificationGroup> findAll() {
        return notificationGroupRepository.findAll();
    }

    @Override
    public Page<NotificationGroup> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return notificationGroupRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort));
    }
}
