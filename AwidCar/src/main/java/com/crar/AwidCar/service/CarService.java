package com.crar.AwidCar.service;

import com.crar.AwidCar.mapper.CarMapper;
import com.crar.AwidCar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper mapper = Mappers.getMapper(CarMapper.class);
}
