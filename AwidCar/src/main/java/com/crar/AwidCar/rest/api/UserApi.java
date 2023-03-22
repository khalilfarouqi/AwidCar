package com.crar.AwidCar.rest.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "User", description = "REST API for User information")
@RequestMapping("/v1/user")
public interface UserApi {
}
