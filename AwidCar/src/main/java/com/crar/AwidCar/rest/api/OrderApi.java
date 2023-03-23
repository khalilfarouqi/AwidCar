package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Order", description = "REST API for Order information")
@RequestMapping("/v1/order")
public interface OrderApi {
    @PostMapping
    Order save(@RequestBody Order order);
    @PutMapping
    Order update(@RequestBody Order order);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    Order getOrderById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<Order> getAllOrder();
    @GetMapping(value = "/search")
    Page<Order> search(@RequestParam(defaultValue = "id>0") String query,
                      @RequestParam(defaultValue = "0") Integer page,
                      @RequestParam(defaultValue = "10") Integer size,
                      @RequestParam(defaultValue = "asc") String order,
                      @RequestParam(defaultValue = "id") String sort);
}
