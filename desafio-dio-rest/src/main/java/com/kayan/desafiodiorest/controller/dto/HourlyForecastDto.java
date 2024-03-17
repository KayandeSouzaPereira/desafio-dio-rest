package com.kayan.desafiodiorest.controller.dto;

import com.kayan.desafiodiorest.domain.model.HourlyForecast;
public record HourlyForecastDto(
        Long id,
        String status,
        Integer hour,
        Integer temperature
) {



    public HourlyForecastDto(HourlyForecast model) {
        this(model.getId(), model.getStatus(), model.getHour(), model.getTemperature());
    }

    public HourlyForecast toModel() {
        HourlyForecast model = new HourlyForecast();
        model.setId(this.id);
        model.setHour(this.hour);
        model.setStatus(this.status);
        model.setTemperature(this.temperature);
        return model;
    }

}
