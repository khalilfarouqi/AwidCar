package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.entity.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Client", description = "REST API for client information")
@RequestMapping("/v1/client")
public interface ClientApi {
    @PostMapping
    Client save(@RequestBody Client client);
    @PutMapping
    Client update(@RequestBody Client client);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    Client getClientById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<Client> getAllClient();
    @GetMapping(value = "/search")
    Page<Client> search(@RequestParam(defaultValue = "id>0") String query,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "asc") String order,
                       @RequestParam(defaultValue = "id") String sort);
}
