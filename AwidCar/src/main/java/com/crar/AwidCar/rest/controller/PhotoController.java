package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.dto.PhotoDto;
import com.crar.AwidCar.entity.Roles;
import com.crar.AwidCar.rest.api.PhotoApi;
import com.crar.AwidCar.service.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PhotoController implements PhotoApi {
    private final PhotoService photoService;

    @Override
    @RolesAllowed(Roles.admin)
    public PhotoDto save(PhotoDto photo) {
        return photoService.save(photo);
    }

    @Override
    @RolesAllowed(Roles.admin)
    public PhotoDto update(PhotoDto photo) {
        return photoService.update(photo);
    }

    @Override
    @RolesAllowed(Roles.admin)
    public void delete(Long id) {
        photoService.delete(id);
    }

    @Override
    @RolesAllowed({Roles.admin, Roles.client})
    public PhotoDto getPhotoById(Long id) {
        return photoService.findById(id);
    }

    @Override
    @RolesAllowed({Roles.admin, Roles.client})
    public List<PhotoDto> getAllPhoto() {
        return photoService.findAll();
    }

    @Override
    public Page<PhotoDto> search(String query, Integer page, Integer size, String order, String sort) {
        return photoService.rsqlQuery(query, page, size, order, sort);
    }
}
