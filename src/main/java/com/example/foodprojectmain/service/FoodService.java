package com.example.foodprojectmain.service;

import com.example.foodprojectmain.mapper.FoodMapper;
import com.example.foodprojectmain.model.FoodDto;
import com.example.foodprojectmain.dao.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodDto> getFirstFourPopularItems() {
        var foodEntityList = foodRepository.findAllRestaurantsPopularItem();
        var foodDtoListMapped = foodEntityList.parallelStream().map(item -> FoodMapper.INSTANCE.mapToDto(item)).toList();
        var firstFiveFoodDtoList = foodDtoListMapped.parallelStream().filter(item -> foodDtoListMapped.indexOf(item) < 4).toList();

        return firstFiveFoodDtoList;
    }

    public List<FoodDto> getSecondFourPopularItems() {
        var foodEntityList = foodRepository.findAllRestaurantsPopularItem();
        var foodDtoListMapped = foodEntityList.parallelStream().map(item -> FoodMapper.INSTANCE.mapToDto(item)).toList();
        var secondFiveFoodDtoList = foodDtoListMapped.stream().filter(item -> foodDtoListMapped.indexOf(item) >= 4 && foodDtoListMapped.indexOf(item) < 8).toList();

        return secondFiveFoodDtoList;
    }

    public List<Restaurant> getFirstRestaurants() {
        var restaurantsName = foodRepository.findAllRestaurantsName().stream().sorted().toList();
        var restaurantsLogo = foodRepository.findAllRestaurantsLogo().stream().sorted().toList();
        List<Restaurant> restaurantList = new ArrayList();
        int i = 0;
        while (i<restaurantsLogo.size() && i < restaurantsName.size() && i<4){
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName(restaurantsName.get(i));
            restaurant.setRestaurantLogo(restaurantsLogo.get(i));
            restaurantList.add(restaurant);
            i++;
        }

        return restaurantList;

    }

    public List<Restaurant> getSecondRestaurants() {
        var restaurantsName = foodRepository.findAllRestaurantsName().stream().sorted().toList();
        var restaurantsLogo = foodRepository.findAllRestaurantsLogo().stream().sorted().toList();
        List<Restaurant> restaurantList2 = new ArrayList();
        int i = 4;
        while (i<restaurantsLogo.size() && i < restaurantsName.size() && i<8) {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName(restaurantsName.get(i));
            restaurant.setRestaurantLogo(restaurantsLogo.get(i));
            restaurantList2.add(restaurant);
            i++;
        }
        return restaurantList2;
    }
    public List<FoodDto> getAllProducts(){
        var foodEntityList = foodRepository.findAll();
        var foodDtoListMapped = foodEntityList.parallelStream().map(item -> FoodMapper.INSTANCE.mapToDto(item)).toList();
        return foodDtoListMapped;
    }
}






