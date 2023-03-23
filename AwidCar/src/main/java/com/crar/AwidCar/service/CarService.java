package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.CarDto;
import com.crar.AwidCar.entity.Car;
import com.crar.AwidCar.exception.*;
import com.crar.AwidCar.mapper.CarMapper;
import com.crar.AwidCar.repository.CarRepository;
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
public class CarService implements IBaseService<Car, CarDto> {
    private final CarRepository carRepository;
    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Override
    @Transactional
    public CarDto save(CarDto carDto) {
        return carMapper.toDto(carRepository.save(carMapper.toEntity(carDto)));
    }

    @Override
    @Transactional
    public CarDto update(CarDto carDto) {
        if (findById(carDto.getId()).equals(null))
            throw new ResourceNotFoundException("car not fond");
        return carMapper.toDto(carRepository.save(carMapper.toEntity(carDto)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto findById(Long id) {
        return carMapper.toDto(carRepository.findById(id).get());
    }

    @Override
    public List<CarDto> findAll() {
        return carMapper.toDto(carRepository.findAll());
    }

    @Override
    public Page<CarDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return carMapper.toDto(carRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
