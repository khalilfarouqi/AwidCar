package com.crar.AwidCar.service.implementation;

import com.crar.AwidCar.mapper.NotificationMapper;
import com.crar.AwidCar.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper mapper = Mappers.getMapper(NotificationMapper.class);
}
