package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.Client;
import com.crar.AwidCar.rest.api.ClientApi;
import com.crar.AwidCar.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClientController implements ClientApi {
    private final ClientService clientService;
    @Override
    public Client save(Client client) {
        return clientService.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientService.update(client);
    }

    @Override
    public void delete(Long id) {
        clientService.delete(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public List<Client> getAllClient() {
        return clientService.findAll();
    }

    @Override
    public Page<Client> search(String query, Integer page, Integer size, String order, String sort) {
        return clientService.rsqlQuery(query, page, size, order, sort);
    }
}
