package test.restapi.cities.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import test.restapi.cities.exception.ModelExistsException;
import test.restapi.cities.exception.NotFoundException;
import test.restapi.cities.model.City;
import test.restapi.cities.model.Image;
import test.restapi.cities.repository.CityRepository;
import test.restapi.cities.service.CityService;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City getCityByName(String name) {
        return cityRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(
                        String.format("The city with name %S isn't found", name)));
    }

    @Override
    public List<City> getPageOfCities(PageRequest pageRequest) {
        return cityRepository.findAll(pageRequest).getContent();
    }

    @Override
    public City editCityById(City editedCity) {
        City city = cityRepository.findById(editedCity.getId())
                .orElseThrow(() -> new NotFoundException(
                String.format("The city with name %S isn't found", editedCity.getId())));
        city.setName(editedCity.getName());

        List<Image> images = city.getImages();
        images.addAll(editedCity.getImages());
        images.forEach(image -> image.setName(city.getName()));
        city.getImages().forEach(image -> image.setCity(city));
        city.setImages(images);

        cityRepository.save(city);
        return city;
    }

    @Override
    public City loadCity(City city) {
        if(cityRepository.findByName(city.getName()).isPresent()){
            throw new ModelExistsException("City already taken");
        }
        city.getImages().forEach(image -> image.setCity(city));
        city.getImages().forEach(image -> image.setName(city.getName()));
        cityRepository.save(city);
        return city;
    }
}
