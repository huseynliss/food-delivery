package com.example.foodprojectmain.dao.repository;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    @Query(value="select max(f) from FoodEntity f group by f.location")
    List<FoodEntity> findAllRestaurantsPopularItem();
    @Query(value = "select distinct f.location from FoodEntity f")
    List<String> findAllRestaurantsName();

    @Query(value = "select distinct f.restaurantLogo from FoodEntity f")
    List<String> findAllRestaurantsLogo();





}
