package com.example.foodprojectmain.mapper;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.model.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDto mapToDto(FoodEntity foodEntity);
}
