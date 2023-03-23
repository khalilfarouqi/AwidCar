package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.User;
import com.crar.AwidCar.rest.api.UserApi;
import com.crar.AwidCar.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {
    private final UserService userService;
    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User update(User user) {
        return userService.save(user);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    public User getUserById(Long id) {
        return userService.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @Override
    public Page<User> search(String query, Integer page, Integer size, String order, String sort) {
        return userService.rsqlQuery(query, page, size, order, sort);
    }
}
