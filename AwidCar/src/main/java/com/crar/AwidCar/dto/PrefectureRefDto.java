package com.crar.AwidCar.dto;

import com.crar.AwidCar.entity.Immatriculation;
import com.crar.AwidCar.entity.enums.Prefecture;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrefectureRefDto implements Serializable {
    private Long id;
    private int code;
    private Prefecture prefecture;
    private List<ImmatriculationDto> immatriculationsDtos;
}
