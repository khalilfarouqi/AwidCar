package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Notification", description = "REST API for Notification information")
@RequestMapping("/v1/notification")
public interface NotificationApi {
    @PostMapping
    Notification save(@RequestBody Notification notification);
    @PutMapping
    Notification update(@RequestBody Notification notification);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    Notification getNotificationById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<Notification> getAllNotification();
    @GetMapping(value = "/search")
    Page<Notification> search(@RequestParam(defaultValue = "id>0") String query,
                        @RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "10") Integer size,
                        @RequestParam(defaultValue = "asc") String order,
                        @RequestParam(defaultValue = "id") String sort);
}
