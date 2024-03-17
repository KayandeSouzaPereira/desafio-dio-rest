package com.kayan.desafiodiorest.service.impl;

import com.kayan.desafiodiorest.domain.model.City;
import com.kayan.desafiodiorest.domain.repository.CityRepository;
import com.kayan.desafiodiorest.service.CityService;
import com.kayan.desafiodiorest.service.exception.BusinessException;
import com.kayan.desafiodiorest.service.exception.NotFoundException;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }
    @Transactional(readOnly = true)
    public List<City> findall() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public City findByID(Long id) {
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public City create(City entity) {

        this.validateChangeableId(entity.getId(), "created");
        return this.repository.save(entity);
    }

    @Transactional
    public City update(Long id, City cityUpdate) {
        this.validateChangeableId(id, "updated");
        City cityOld = this.findByID(id);

        cityOld.setCityName(cityUpdate.getCityName());
        cityOld.setCountry(cityUpdate.getCountry());
        cityOld.setTemperature(cityUpdate.getTemperature());
        cityOld.setStatus(cityUpdate.getStatus());
        cityOld.setHigh(cityUpdate.getHigh());
        cityOld.setLow(cityUpdate.getLow());
        cityOld.setHourlyForecast(cityUpdate.getHourlyForecast());

        return this.repository.save(cityOld);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        City city = this.findByID(id);
        this.repository.delete(city);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("City with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
