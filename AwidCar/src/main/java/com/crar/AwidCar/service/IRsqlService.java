package com.crar.AwidCar.service;

import org.springframework.data.domain.Page;

public interface IRsqlService<E> {
    Page<E> rsqlQuery(String query, Integer page, Integer size, String order, String sort);
}
