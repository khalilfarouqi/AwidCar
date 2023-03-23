package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.ClientDto;
import com.crar.AwidCar.entity.Client;
import com.crar.AwidCar.exception.*;
import com.crar.AwidCar.mapper.ClientMapper;
import com.crar.AwidCar.repository.ClientRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService implements IBaseService<Client, ClientDto> {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    @Override
    @Transactional
    public ClientDto save(ClientDto client) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto client) {
        Boolean exist = findById(client.getId()).getOrderDtoList().isEmpty();
        if (exist == false) throw new InvalidInputException("client not fond");
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto findById(Long id) {
        ClientDto clientDto = clientMapper.toDto(clientRepository.findById(id).get());
        if (clientDto == null) throw new InvalidInputException("client not fond");
        return clientDto;
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.toDto(clientRepository.findAll());
    }

    @Override
    public Page<ClientDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return clientMapper.toDto(clientRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
