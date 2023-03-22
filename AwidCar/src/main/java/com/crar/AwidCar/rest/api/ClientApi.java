package com.crar.AwidCar.rest.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Client", description = "REST API for client information")
@RequestMapping("/v1/client")
public interface ClientApi {
}
