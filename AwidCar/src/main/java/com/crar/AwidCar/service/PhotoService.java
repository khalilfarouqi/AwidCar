package com.crar.AwidCar.service;

import com.crar.AwidCar.dto.PhotoDto;
import com.crar.AwidCar.entity.Photo;
import com.crar.AwidCar.exception.InvalidInputException;
import com.crar.AwidCar.exception.ResourceNotFoundException;
import com.crar.AwidCar.mapper.PhotoMapper;
import io.github.perplexhub.rsql.RSQLJPASupport;
import com.crar.AwidCar.repository.*;
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
public class PhotoService implements IBaseService<Photo, PhotoDto> {
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper = Mappers.getMapper(PhotoMapper.class);
    @Transactional
    public PhotoDto save(PhotoDto photo){
        return photoMapper.toDto(photoRepository.save(photoMapper.toEntity(photo)));
    }

    @Override
    @Transactional
    public PhotoDto update(PhotoDto photo) {
        if (findById(photo.getId()).equals(null))
            throw new ResourceNotFoundException("photo not fond");
        return photoMapper.toDto(photoRepository.save(photoMapper.toEntity(photo)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public PhotoDto findById(Long id) {
        return photoMapper.toDto(photoRepository.findById(id).get());
    }

    @Override
    public List<PhotoDto> findAll() {
        return photoMapper.toDto(photoRepository.findAll());
    }

    @Override
    public Page<PhotoDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return photoMapper.toDto(photoRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)));
    }
}
