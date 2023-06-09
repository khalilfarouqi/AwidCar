package com.crar.AwidCar.dto;

import com.crar.AwidCar.entity.enums.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private Long id;
    private Date lastCheckIn;
    private String userName;
    private String passWord;
    private Roles roles;
    private List<OrderDto> orderDtoList;
}
