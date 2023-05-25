package test.restapi.cities.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import test.restapi.cities.dto.entityDto.CityDto;
import test.restapi.cities.dto.entityDto.EditCityDto;
import test.restapi.cities.facade.CityFacade;
import test.restapi.cities.mapper.CityMapper;
import test.restapi.cities.mapper.EditCityMapper;
import test.restapi.cities.service.CityService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CityFacadeImpl implements CityFacade {

    private final CityService cityService;
    private final CityMapper cityMapper;
    private final EditCityMapper editCityMapper;
    @Override
    public CityDto getCityByName(String cityName) {
        return cityMapper.toDto(cityService.getCityByName(cityName));
    }

    @Override
    public List<CityDto> getPageOfCities(int page, int size) {
        return cityService.getPageOfCities(PageRequest.of(page, size, Sort.by("id"))).stream().map(cityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EditCityDto editCity(EditCityDto cityDto) {
        return editCityMapper.toDto(cityService.editCityById(editCityMapper.toEntity(cityDto)));
    }

    @Override
    public CityDto loadCity(CityDto cityDto) {
        return cityMapper.toDto(cityService.loadCity(cityMapper.toEntity(cityDto)));
    }
}
