package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
    List<PhotoDto> toDto(List<Photo> photoList);
    Photo toEntity(PhotoDto photoDto);
    List<Photo> toEntity(List<PhotoDto> photoDtoList);
    Page<PhotoDto> toDto(Page<Photo> photoPage);
}
