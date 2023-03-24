package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.entity.Photo;
import com.crar.AwidCar.rest.api.PhotoApi;
import com.crar.AwidCar.service.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PhotoController implements PhotoApi {
    private final PhotoService photoService;

    @Override
    public Photo save(Photo photo) {
        return photoService.save(photo);
    }

    @Override
    public Photo update(Photo photo) {
        return photoService.update(photo);
    }

    @Override
    public void delete(Long id) {
        photoService.delete(id);
    }

    @Override
    public Photo getPhotoById(Long id) {
        return photoService.findById(id);
    }

    @Override
    public List<Photo> getAllPhoto() {
        return photoService.findAll();
    }

    @Override
    public Page<Photo> search(String query, Integer page, Integer size, String order, String sort) {
        return photoService.rsqlQuery(query, page, size, order, sort);
    }
}
