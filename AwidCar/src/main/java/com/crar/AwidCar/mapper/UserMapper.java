package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDto(List<User> userList);
    User toEntity(UserDto userDto);
    List<User> toEntity(List<UserDto> userDtoList);
    Page<UserDto> toDto(Page<User> userPage);
}
