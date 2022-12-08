package com.example.foodprojectmain.mapper;

import
        com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.dao.entity.LocationEntity;
import com.example.foodprojectmain.model.FoodDto;
import com.example.foodprojectmain.model.LocationDto;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDto mapToDto(LocationEntity locationEntity);
}
