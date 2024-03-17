package com.kayan.desafiodiorest.controller.dto;

import com.kayan.desafiodiorest.domain.model.City;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;


public record CityDto(
        Long id,
        String cityName,
        String country,
        Integer temperature,
        Integer high,
        Integer low,
        String status,
        List<HourlyForecastDto> hourlyForecast
) {
    public CityDto(City model) {
        this(
                model.getId(),
                model.getCityName(),
                model.getCountry(),
                model.getTemperature(),
                model.getHigh(),
                model.getLow(),
                model.getStatus(),
                ofNullable(model.getHourlyForecast()).orElse(emptyList()).stream().map(HourlyForecastDto::new).collect(toList())
        );
    }

    public City toModel() {
        City model = new City();

        model.setId(this.id);
        model.setCityName(this.cityName);
        model.setCountry(this.country);
        model.setTemperature(this.temperature);
        model.setHigh(this.high);
        model.setLow(this.low);
        model.setStatus(this.status);
        model.setHourlyForecast(ofNullable(this.hourlyForecast).orElse(emptyList()).stream().map(HourlyForecastDto::toModel).collect(toList()));

        return model;
    }



}
