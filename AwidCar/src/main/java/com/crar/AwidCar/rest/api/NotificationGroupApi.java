package com.crar.AwidCar.rest.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "NotificationGroup", description = "REST API for NotificationGroup information")
@RequestMapping("/v1/notificationGroup")
public interface NotificationGroupApi {
}
