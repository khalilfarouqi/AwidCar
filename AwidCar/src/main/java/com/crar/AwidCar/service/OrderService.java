package com.crar.AwidCar.service;

import com.crar.AwidCar.entity.Order;
import com.crar.AwidCar.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService implements IBaseService<Order> {
    private final OrderRepository orderRepository;

    @Override
    public Order save(Order dto) {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Page<Order> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        return null;
    }
}
