package test.restapi.cities.facade;

import test.restapi.cities.dto.entityDto.CityDto;
import test.restapi.cities.dto.entityDto.EditCityDto;

import java.util.List;

public interface CityFacade {

    CityDto getCityByName(String cityName);
    List<CityDto> getPageOfCities(int page, int size);

    EditCityDto editCity(EditCityDto cityDto);
    CityDto loadCity(CityDto cityDto);

}
