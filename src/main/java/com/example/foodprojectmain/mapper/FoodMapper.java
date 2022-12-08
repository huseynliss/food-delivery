package com.example.foodprojectmain.mapper;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.model.FoodDto;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.time.LocalDate;

@Mapper
public abstract class FoodMapper {
    public static final FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);


    public FoodDto mapToDto(FoodEntity foodEntity) {
        return FoodDto.builder().name(foodEntity.getName())
                .price(foodEntity.getPrice())
                .currency(foodEntity.getCurrency())
                .image(foodEntity.getImage()).locationEntity(foodEntity.getLocationEntity()).build();
    }
}
