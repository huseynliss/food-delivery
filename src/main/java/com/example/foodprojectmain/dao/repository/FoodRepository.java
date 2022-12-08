package com.example.foodprojectmain.dao.repository;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.model.FoodAndLocationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    @Query(value="select max(f) from FoodEntity f group by f.locationEntity.location")
    List<FoodEntity> findAllRestaurantsPopularItem();

}
