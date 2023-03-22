package com.crar.AwidCar.service.implementation;

import com.crar.AwidCar.mapper.NotificationGroupMapper;
import com.crar.AwidCar.repository.NotificationGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class NotificationGroupService {
    private final NotificationGroupRepository notificationGroupRepository;
    private final NotificationGroupMapper notificationGroupMapper = Mappers.getMapper(NotificationGroupMapper.class);
}
