package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.NotificationGroupDto;
import com.crar.AwidCar.entity.NotificationGroup;
import com.crar.AwidCar.exception.*;
import com.crar.AwidCar.mapper.NotificationGroupMapper;
import com.crar.AwidCar.repository.NotificationGroupRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class NotificationGroupService implements IBaseService<NotificationGroup, NotificationGroupDto> {
    private final NotificationGroupRepository notificationGroupRepository;
    private final NotificationGroupMapper notificationGroupMapper = Mappers.getMapper(NotificationGroupMapper.class);

    @Override
    @Transactional
    public NotificationGroupDto save(NotificationGroupDto notificationGroup) {
        return notificationGroupMapper.toDto(notificationGroupRepository.save(notificationGroupMapper.toEntity(notificationGroup)));
    }

    @Override
    @Transactional
    public NotificationGroupDto update(NotificationGroupDto notificationGroup) {
        Boolean exist = findById(notificationGroup.getId()).getNotificationWeb();
        if (exist == false) throw new ResourceNotFoundException("Notification Group not fond");
        return notificationGroupMapper.toDto(notificationGroupRepository.save(notificationGroupMapper.toEntity(notificationGroup)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        notificationGroupRepository.deleteById(id);
    }

    @Override
    public NotificationGroupDto findById(Long id) {
        NotificationGroupDto notificationGroupDto = notificationGroupMapper.toDto(notificationGroupRepository.findById(id).get());
        if (notificationGroupDto == null) throw new InvalidInputException("notification Group not fond");
        return notificationGroupDto;
    }

    @Override
    public List<NotificationGroupDto> findAll() {
        return notificationGroupMapper.toDto(notificationGroupRepository.findAll());
    }

    @Override
    public Page<NotificationGroupDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return notificationGroupMapper.toDto(notificationGroupRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
