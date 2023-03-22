package com.crar.AwidCar.rest.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Photo", description = "REST API for Photo information")
@RequestMapping("/v1/photo")
public interface PhotoApi {
}
