package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.dto.ClientDto;
import com.crar.AwidCar.entity.Roles;
import com.crar.AwidCar.rest.api.ClientApi;
import com.crar.AwidCar.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RolesAllowed({Roles.admin, Roles.client})
public class ClientController implements ClientApi {
    private final ClientService clientService;
    @Override
    public ClientDto save(ClientDto client) {
        return clientService.save(client);
    }

    @Override
    public ClientDto update(ClientDto client) {
        return clientService.update(client);
    }

    @Override
    @RolesAllowed(Roles.admin)
    public void delete(Long id) {
        clientService.delete(id);
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> getAllClient() {
        return clientService.findAll();
    }

    @Override
    public Page<ClientDto> search(String query, Integer page, Integer size, String order, String sort) {
        return clientService.rsqlQuery(query, page, size, order, sort);
    }
}
