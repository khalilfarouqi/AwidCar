package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.dto.CarDto;
import com.crar.AwidCar.entity.Roles;
import com.crar.AwidCar.rest.api.CarApi;
import com.crar.AwidCar.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CarController implements CarApi {
    private final CarService carService;
    @Override
    @RolesAllowed(Roles.admin)
    public CarDto save(CarDto car) {
        return carService.save(car);
    }

    @Override
    @RolesAllowed(Roles.admin)
    public CarDto update(CarDto car) {
        return carService.update(car);
    }

    @Override
    @RolesAllowed(Roles.admin)
    public void delete(Long id) {
        carService.delete(id);
    }

    @Override
    @RolesAllowed({Roles.admin, Roles.client})
    public CarDto getCarById(Long id) {
        return carService.findById(id);
    }

    @Override
    @RolesAllowed({Roles.admin, Roles.client})
    public List<CarDto> getAllCar() {
        return carService.findAll();
    }

    @Override
    public Page<CarDto> search(String query, Integer page, Integer size, String order, String sort) {
        return carService.rsqlQuery(query, page, size, order, sort);
    }
}
