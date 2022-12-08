package com.example.foodprojectmain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodAndLocationDto {
    private String name;
    private Double price;
    private String currency;
    private String image;
    private String location;
    private String restaurantLogo;
}
