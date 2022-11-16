package com.example.foodprojectmain.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products_main")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {
    @Id
    private Long id;
    private String name;
    private Double price;
    private String currency;
    private String image;
    private String location;
    @Column(name ="restaurant_logo")
    private String restaurantLogo;

}
