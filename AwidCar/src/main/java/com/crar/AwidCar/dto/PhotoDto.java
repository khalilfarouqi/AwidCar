package com.crar.AwidCar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhotoDto {
    private Long id;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private CarDto carDto;
}
