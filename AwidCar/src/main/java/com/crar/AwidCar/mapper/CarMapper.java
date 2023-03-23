package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.CarDto;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car car);
    List<CarDto> toDto(List<Car> carList);
    Car toEntity(CarDto carDto);
    List<Car> toEntity(List<CarDto> carDtoList);
    Page<CarDto> toDto(Page<Car> carPage);
}
