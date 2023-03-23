package com.crar.AwidCar.service;

import com.crar.AwidCar.entity.Order;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.repository.OrderRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService implements IBaseService<Order> {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order update(Order order) {
        if (findById(order.getId()).equals(null))
            throw new ResourceNotFoundException("Order not fond");
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        return orderRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort));
    }
}
