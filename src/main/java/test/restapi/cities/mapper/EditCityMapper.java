package test.restapi.cities.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.restapi.cities.dto.entityDto.EditCityDto;
import test.restapi.cities.model.City;

@Component
public class EditCityMapper extends AbstractMapper<City, EditCityDto>{

    @Autowired
    public EditCityMapper() {
        super(City.class, EditCityDto.class);
    }

}
