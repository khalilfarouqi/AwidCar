package com.crar.AwidCar.service;

import com.crar.AwidCar.entity.Car;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.repository.CarRepository;
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
public class CarService implements IBaseService<Car> {
    private final CarRepository carRepository;

    @Override
    @Transactional
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car update(Car car) {
        if (findById(car.getId()).equals(null))
            throw new ResourceNotFoundException("car not fond");
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return carRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort));
    }
}
