package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "User", description = "REST API for User information")
@RequestMapping("/v1/user")
public interface UserApi {
    @PostMapping
    User save(@RequestBody User user);
    @PutMapping
    User update(@RequestBody User user);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    User getUserById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<User> getAllUser();
    @GetMapping(value = "/search")
    Page<User> search(@RequestParam(defaultValue = "id>0") String query,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "asc") String order,
                       @RequestParam(defaultValue = "id") String sort);
}
