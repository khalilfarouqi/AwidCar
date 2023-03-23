package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "NotificationGroup", description = "REST API for NotificationGroup information")
@RequestMapping("/v1/notificationGroup")
public interface NotificationGroupApi {
    @PostMapping
    NotificationGroup save(@RequestBody NotificationGroup notificationGroup);
    @PutMapping
    NotificationGroup update(@RequestBody NotificationGroup notificationGroup);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    NotificationGroup getNotificationGroupById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<NotificationGroup> getAllNotificationGroup();
    @GetMapping(value = "/search")
    Page<NotificationGroup> search(@RequestParam(defaultValue = "id>0") String query,
                        @RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "10") Integer size,
                        @RequestParam(defaultValue = "asc") String order,
                        @RequestParam(defaultValue = "id") String sort);
}
