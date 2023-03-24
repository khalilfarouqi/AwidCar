package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.Order;
import com.crar.AwidCar.rest.api.OrderApi;
import com.crar.AwidCar.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController implements OrderApi {
    private final OrderService orderService;
    @Override
    public Order save(Order order) {
        return orderService.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderService.update(order);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderService.findById(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderService.findAll();
    }

    @Override
    public Page<Order> search(String query, Integer page, Integer size, String order, String sort) {
        return orderService.rsqlQuery(query, page, size, order, sort);
    }
}
