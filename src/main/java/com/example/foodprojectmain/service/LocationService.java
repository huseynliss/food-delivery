package com.example.foodprojectmain.service;
import com.example.foodprojectmain.dao.entity.LocationEntity;
import com.example.foodprojectmain.dao.repository.LocationRepository;
import com.example.foodprojectmain.mapper.LocationMapper;
import com.example.foodprojectmain.dao.repository.FoodRepository;
import com.example.foodprojectmain.model.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final FoodRepository foodRepository;


    public LocationService(FoodRepository foodRepository, LocationRepository locationRepository, FoodRepository foodRepository1) {

        this.locationRepository = locationRepository;
        this.foodRepository = foodRepository1;
    }

    public List<LocationDto> getAllLocations(){
        var locationEntityList = locationRepository.findAll();
        var locationDtoListMapped = locationEntityList.parallelStream().map(item -> LocationMapper.INSTANCE.mapToDto(item)).toList();
        return locationDtoListMapped;
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

    public void deleteLocation(long id) {
        for (int i = 0; i < foodRepository.findAll().size(); i++) {
            if (id == foodRepository.findAll().get(i).getLocationId()){
                foodRepository.deleteByLocationId(id);
            }
        }

        locationRepository.deleteById(id);

    }

    public void saveLocation(LocationEntity locationEntity) {
        LocationEntity locationEntity1 = new LocationEntity();
        locationEntity1.setLocation(locationEntity.getLocation());
        locationEntity1.setRestaurantLogo(locationEntity.getRestaurantLogo());
        locationRepository.save(locationEntity1);
    }
    public Long findLastLocationEntityId(){
        return locationRepository.findLastEntityId();
    }
}
