package com.example.foodprojectmain.service;
import com.example.foodprojectmain.dao.repository.LocationRepository;
import com.example.foodprojectmain.mapper.FoodMapper;
import com.example.foodprojectmain.mapper.LocationMapper;
import com.example.foodprojectmain.model.FoodDto;
import com.example.foodprojectmain.dao.repository.FoodRepository;
import com.example.foodprojectmain.model.LocationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(FoodRepository foodRepository, LocationRepository locationRepository) {

        this.locationRepository = locationRepository;
    }

    public List<LocationDto> getFirstRestaurants() {
        var locationLists = locationRepository.findAll();
        var mappedLocationList = locationLists.parallelStream().map((item)-> LocationMapper.INSTANCE.mapToDto(item)).toList();
        return mappedLocationList.parallelStream().filter((item)->mappedLocationList.indexOf(item)<4).toList();

    }

    public List<LocationDto> getSecondRestaurants() {
        var locationLists = locationRepository.findAll();
        var mappedLocationList = locationLists.parallelStream().map((item)-> LocationMapper.INSTANCE.mapToDto(item)).toList();
        return mappedLocationList.parallelStream().filter((item)->mappedLocationList.indexOf(item)>=4 && mappedLocationList.indexOf(item)<8).toList();
    }
}
