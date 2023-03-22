package com.crar.AwidCar.service.implementation;

import com.crar.AwidCar.mapper.ClientMapper;
import com.crar.AwidCar.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper = Mappers.getMapper(ClientMapper.class);
}
