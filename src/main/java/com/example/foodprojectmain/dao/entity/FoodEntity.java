package com.example.foodprojectmain.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products_main")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String currency;
    private String image;
    @Column(name = "location_id")
    private Long locationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private LocationEntity locationEntity;

}
