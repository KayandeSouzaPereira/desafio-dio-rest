package com.kayan.desafiodiorest.controller;


import com.kayan.desafiodiorest.controller.dto.CityDto;
import com.kayan.desafiodiorest.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/cityForecast")
@Tag(name = "City Forecast Controller", description = "RESTful API for managing city forecast.")
public record CityController(CityService service) {

    @GetMapping
    @Operation(summary = "Get all city forecast", description = "Retrieve a list of all registered city forecast")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<CityDto>> findAll() {
        var cities = service.findall();
        var citiesDto = cities.stream().map(CityDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(citiesDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get city forecast by id", description = "Retrieve a city forecast")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<CityDto> findById(@PathVariable Long id) {
        var city = service.findByID(id);
        return ResponseEntity.ok(new CityDto(city));
    }

    @PostMapping
    @Operation(summary = "Create a new city forecast", description = "Create a new city forecast and return the created city forecast data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "City forecast created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid city forecast data provided")
    })
    public ResponseEntity<CityDto> create(@RequestBody CityDto cityDto) {
        var city = service.create(cityDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city.getId())
                .toUri();
        return ResponseEntity.created(location).body(new CityDto(city));
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update city forecast", description =  "Update the city forecast of an existing data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City forecast updated successfully"),
            @ApiResponse(responseCode = "404", description = "City forecast not found"),
            @ApiResponse(responseCode = "422", description = "Invalid city forecast data provided")
    })
    public ResponseEntity<CityDto> update(@PathVariable Long id, @RequestBody CityDto cityDto){
        var city = service.update(id, cityDto.toModel());
        return ResponseEntity.ok(new CityDto(city));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete city forecast", description = "Delete an existing city forecast by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "City Forecast deleted successfully"),
            @ApiResponse(responseCode = "404", description = "City Forecast not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
