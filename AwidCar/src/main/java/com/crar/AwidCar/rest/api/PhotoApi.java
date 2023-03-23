package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.Photo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Photo", description = "REST API for Photo information")
@RequestMapping("/v1/photo")
public interface PhotoApi {
    @PostMapping
    Photo save(@RequestBody Photo photo);
    @PutMapping
    Photo update(@RequestBody Photo photo);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    Photo getPhotoById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<Photo> getAllPhoto();
    @GetMapping(value = "/search")
    Page<Photo> search(@RequestParam(defaultValue = "id>0") String query,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "asc") String order,
                       @RequestParam(defaultValue = "id") String sort);
}
