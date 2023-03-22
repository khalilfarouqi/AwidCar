package com.crar.AwidCar.rest.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin
@Tag(name = "Car", description = "REST API for Car information")
@RequestMapping("/v1/car")
public interface CarApi {
}
