package com.crar.AwidCar.mapper;

import com.crar.AwidCar.dto.*;
import com.crar.AwidCar.entity.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);
    List<ClientDto> toDto(List<Client> clientList);
    Client toEntity(ClientDto clientDto);
    List<Client> toEntity(List<ClientDto> clientDtoList);
    Page<ClientDto> toDto(Page<Client> clientPage);
}
