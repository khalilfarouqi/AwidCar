package com.crar.AwidCar.service;

import java.io.Serializable;

public interface IBaseService<E> extends IRsqlService<E> {
    E save(E dto);

    E update(E dto);

    void delete(Long id);

    E findById(Long id);
}
