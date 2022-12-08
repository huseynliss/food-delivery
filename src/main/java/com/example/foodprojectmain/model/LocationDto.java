package com.example.foodprojectmain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;
    private String location;
    private String restaurantLogo;

}
