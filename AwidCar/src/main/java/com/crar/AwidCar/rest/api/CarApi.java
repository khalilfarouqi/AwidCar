package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@CrossOrigin
@Tag(name = "Car", description = "REST API for Car information")
@RequestMapping("/v1/car")
public interface CarApi {
    @PostMapping
    Car save(@RequestBody Car car);
    @PutMapping
    Car update(@RequestBody Car car);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    Car getCarById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<Car> getAllCar();
    @GetMapping(value = "/search")
    Page<Car> search(@RequestParam(defaultValue = "id>0") String query,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "asc") String order,
                       @RequestParam(defaultValue = "id") String sort);
}
