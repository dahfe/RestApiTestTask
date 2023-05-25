package test.restapi.cities.service;

import org.springframework.data.domain.PageRequest;
import test.restapi.cities.model.City;

import java.util.List;

public interface CityService {

    City getCityByName(String name);
    List<City> getPageOfCities(PageRequest pageRequest);
    City editCityById(City editedCity);
    City loadCity(City city);
}
