package com.example.foodprojectmain.dao.repository;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    @Query(value="select max(f) from FoodEntity f group by f.locationEntity.location")
    List<FoodEntity> findAllRestaurantsPopularItem();

    @Transactional
    @Modifying
    @Query(value = "delete from FoodEntity f where f.locationId =:id")
    void deleteByLocationId(long id);





}
