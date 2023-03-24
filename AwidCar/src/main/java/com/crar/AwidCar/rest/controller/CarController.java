package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.Car;
import com.crar.AwidCar.rest.api.CarApi;
import com.crar.AwidCar.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CarController implements CarApi {
    private final CarService carService;
    @Override
    public Car save(Car car) {
        return carService.save(car);
    }

    @Override
    public Car update(Car car) {
        return carService.update(car);
    }

    @Override
    public void delete(Long id) {
        carService.delete(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carService.findById(id);
    }

    @Override
    public List<Car> getAllCar() {
        return carService.findAll();
    }

    @Override
    public Page<Car> search(String query, Integer page, Integer size, String order, String sort) {
        return carService.rsqlQuery(query, page, size, order, sort);
    }
}
