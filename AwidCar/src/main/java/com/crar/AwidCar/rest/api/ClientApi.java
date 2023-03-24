package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.dto.ClientDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Client", description = "REST API for client information")
@RequestMapping("/v1/client")
public interface ClientApi {
    @PostMapping
    ClientDto save(@RequestBody ClientDto client);
    @PutMapping
    ClientDto update(@RequestBody ClientDto client);
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
    @GetMapping(value = "/{id}")
    ClientDto getClientById(@PathVariable("id") Long id);
    @GetMapping(value = "/getAll")
    List<ClientDto> getAllClient();
    @GetMapping(value = "/search")
    Page<ClientDto> search(@RequestParam(defaultValue = "id>0") String query,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "asc") String order,
                       @RequestParam(defaultValue = "id") String sort);
}
