package com.example.foodprojectmain.dao.repository;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

//    @Query("select l from LocationEntity l join l.foodEntityList")
//    List<LocationEntity> findAll();
    @Query(value = "SELECT id FROM locations_main ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    Long findLastEntityId();

}
