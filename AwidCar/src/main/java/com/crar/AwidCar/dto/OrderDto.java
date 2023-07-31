package com.crar.AwidCar.dto;

import com.crar.AwidCar.entity.enums.City;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto implements Serializable {
    private Long id;
    private String country;
    private City bookingCity;
    private City returnCity;
    private Date startDate;
    private Date endDate;
    private int clientAge;
    private String typeInsurance;
    private String orderStatus;
    private CarDto car;
    private ClientDto client;
}
