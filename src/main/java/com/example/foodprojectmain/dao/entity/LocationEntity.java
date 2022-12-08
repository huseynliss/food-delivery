package com.example.foodprojectmain.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations_main")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    @Column(name ="restaurant_logo")
    private String restaurantLogo;

}
