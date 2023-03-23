package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    List<OrderDto> toDto(List<Order> orderList);
    Order toEntity(OrderDto orderDto);
    List<Order> toEntity(List<OrderDto> orderDtoList);
    Page<OrderDto> toDto(Page<Order> orderPage);
}
