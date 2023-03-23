package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.OrderDto;
import com.crar.AwidCar.entity.Order;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.mapper.NotificationGroupMapper;
import com.crar.AwidCar.mapper.OrderMapper;
import com.crar.AwidCar.repository.OrderRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
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
public class OrderService implements IBaseService<Order, OrderDto> {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Override
    @Transactional
    public OrderDto save(OrderDto order) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toEntity(order)));
    }

    @Override
    @Transactional
    public OrderDto update(OrderDto order) {
        if (findById(order.getId()).equals(null))
            throw new ResourceNotFoundException("Order not fond");
        return orderMapper.toDto(orderRepository.save(orderMapper.toEntity(order)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto findById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id).get());
    }

    @Override
    public List<OrderDto> findAll() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    public Page<OrderDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        return orderMapper.toDto(orderRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
