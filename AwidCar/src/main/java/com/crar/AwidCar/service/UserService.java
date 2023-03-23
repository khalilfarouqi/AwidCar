package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.UserDto;
import com.crar.AwidCar.entity.User;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.mapper.UserMapper;
import com.crar.AwidCar.repository.*;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService implements IBaseService<User, UserDto> {
    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    @Override
    @Transactional
    public UserDto save(UserDto user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    @Transactional
    public UserDto update(UserDto user) {
        if (findById(user.getId()).equals(null))
            throw new ResourceNotFoundException("user not fond");
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public Page<UserDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return userMapper.toDto(userRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
