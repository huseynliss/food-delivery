package com.example.foodprojectmain.model;

import com.example.foodprojectmain.dao.entity.LocationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDto {
    private Long id;
    private String name;
    private Double price;
    private String currency;
    private String image;
    private LocationEntity locationEntity;

}
