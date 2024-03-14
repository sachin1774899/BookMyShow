package dev.sachin.BookMyShow.controller;


import dev.sachin.BookMyShow.dto.CityRequestDTO;
import dev.sachin.BookMyShow.model.City;
import dev.sachin.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        try {
            String cityName = cityRequestDTO.getName();
            if(cityName==null || cityName.isBlank() || cityName.isEmpty()){
                throw new Exception("City Name is invalid");
            }
            City saveCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(saveCity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
