package com.example.foodprojectmain.service;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.mapper.FoodMapper;
import com.example.foodprojectmain.model.FoodDto;
import com.example.foodprojectmain.dao.repository.FoodRepository;
import org.springframework.stereotype.Service;

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


    public List<FoodDto> getAllProducts(){
        var foodEntityList = foodRepository.findAll();
        var foodDtoListMapped = foodEntityList.parallelStream().map(item -> FoodMapper.INSTANCE.mapToDto(item)).toList();
        return foodDtoListMapped;
    }


}






