package com.crar.AwidCar.service;

import com.crar.AwidCar.entity.Photo;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import io.github.perplexhub.rsql.RSQLJPASupport;
import com.crar.AwidCar.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PhotoService implements IBaseService<Photo> {
    private final PhotoRepository photoRepository;
    @Transactional
    public Photo save(Photo photo){
        return photoRepository.save(photo);
    }

    @Override
    @Transactional
    public Photo update(Photo photo) {
        if (findById(photo.getId()).equals(null))
            throw new ResourceNotFoundException("photo not fond");
        return photoRepository.save(photo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).get();
    }

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Page<Photo> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return photoRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort));
    }
}
