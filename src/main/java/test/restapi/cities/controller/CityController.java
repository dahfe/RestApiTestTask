package test.restapi.cities.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.restapi.cities.dto.entityDto.CityDto;
import test.restapi.cities.dto.entityDto.EditCityDto;
import test.restapi.cities.facade.CityFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
@Slf4j
public class CityController {

    private final CityFacade cityFacade;

    @GetMapping("/city/{name}")
    public ResponseEntity<CityDto> getCityByName(@PathVariable(name = "name") String cityName){
        return new ResponseEntity<>(cityFacade.getCityByName(cityName), HttpStatus.OK);
    }

    @GetMapping("/getCities")
    public ResponseEntity<List<CityDto>> getPageOfCities(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return new ResponseEntity<>(cityFacade.getPageOfCities(page, size), HttpStatus.OK);
    }

    @PostMapping("/city/editing")
    public ResponseEntity<EditCityDto> editCity(@RequestBody @Valid EditCityDto cityDto) {
        return new ResponseEntity<>(cityFacade.editCity(cityDto), HttpStatus.OK);
    }

    @PostMapping(value = "/city/loading", consumes = {"application/json"})
    public ResponseEntity<CityDto> loadCity(@RequestBody @Valid CityDto cityDto) {
        return new ResponseEntity<>(cityFacade.loadCity(cityDto), HttpStatus.OK);
    }
}
