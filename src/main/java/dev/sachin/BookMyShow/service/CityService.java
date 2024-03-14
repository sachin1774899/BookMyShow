package dev.sachin.BookMyShow.service;

import dev.sachin.BookMyShow.model.City;
import dev.sachin.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public City getCityName(String cityName){
        City city  = cityRepository.findCityByName(cityName);
        return city;
    }

//    public Optional<City> getCityById(int id){
//        Optional<City> city = cityRepository.findById(id);
//        return city;
//    }

    public boolean deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return true;
    }
}
