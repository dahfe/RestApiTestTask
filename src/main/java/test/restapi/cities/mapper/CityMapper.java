package test.restapi.cities.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.restapi.cities.dto.entityDto.CityDto;
import test.restapi.cities.model.City;

@Component
public class CityMapper extends AbstractMapper<City, CityDto>{

    @Autowired
    public CityMapper() {
        super(City.class, CityDto.class);
    }
}
