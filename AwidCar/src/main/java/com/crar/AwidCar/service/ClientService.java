package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.ClientDto;
import com.crar.AwidCar.entity.Client;
import com.crar.AwidCar.exception.*;
import com.crar.AwidCar.repository.ClientRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService implements IBaseService<Client, ClientDto> {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public ClientDto save(ClientDto client) {
        return modelMapper.map(clientRepository.save(modelMapper.map(client, Client.class)), ClientDto.class);
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto client) {
        Boolean exist = findById(client.getId()).getOrderDtoList().isEmpty();
        if (exist == false) throw new InvalidInputException("client not fond");
        return modelMapper.map(clientRepository.save(modelMapper.map(client, Client.class)), ClientDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto findById(Long id) {
        ClientDto clientDto = modelMapper.map(clientRepository.findById(id).get(), ClientDto.class);
        if (clientDto == null) throw new InvalidInputException("client not fond");
        return clientDto;
    }

    @Override
    public List<ClientDto> findAll() {
        return (List<ClientDto>) modelMapper.map(clientRepository.findAll(), ClientDto.class);
    }

    @Override
    public Page<ClientDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return (Page<ClientDto>) modelMapper.map(clientRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)), ClientDto.class);
    }
}
