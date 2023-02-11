package com.example.foodprojectmain.controller;

import com.example.foodprojectmain.dao.entity.FoodEntity;
import com.example.foodprojectmain.dao.entity.LocationEntity;
import com.example.foodprojectmain.dao.entity.user.User;
import com.example.foodprojectmain.dao.repository.LocationRepository;
import com.example.foodprojectmain.model.FoodDto;
import com.example.foodprojectmain.model.LocationDto;
import com.example.foodprojectmain.service.FoodService;
import com.example.foodprojectmain.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    private final FoodService foodService;
    private final LocationService locationService;

    @Autowired
    LocationRepository locationRepository;

    public AdminPageController(FoodService foodService, LocationService locationService) {
        this.foodService = foodService;
        this.locationService = locationService;
    }

    @GetMapping({"", "/"})
    public String findAll(Model model) {
        List<LocationDto> locationDtoList = locationService.getAllLocations();
        List<FoodDto> foodDtoList = foodService.getAllProducts();
        model.addAttribute("products", foodDtoList);
        model.addAttribute("locations", locationDtoList);



        return "adminPage";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(Model model) {

        model.addAttribute("product", new FoodEntity());

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute FoodEntity foodEntity, Model model) {

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLocation(foodEntity.getLocationEntity().getLocation());
        locationEntity.setRestaurantLogo(foodEntity.getLocationEntity().getRestaurantLogo());

        FoodEntity foodEntity1 = new FoodEntity();
        foodEntity1.setName(foodEntity.getName());
        foodEntity1.setCurrency(foodEntity.getCurrency());
        foodEntity1.setImage(foodEntity.getImage());
        foodEntity1.setPrice(foodEntity.getPrice());

        locationService.saveLocation(locationEntity);
        foodService.saveProduct(foodEntity1);

        return "redirect:/admin";
    }


//    @PostMapping("/saveProduct")
//    public String saveProduct(@RequestBody FoodEntity foodEntity) {
//        foodService.saveProduct(foodEntity);
//
//        return "redirect:/admin";
//    }

//    @PostMapping("/saveProductLocation")
//    public String addLocation(@RequestBody LocationEntity locationEntity) {
//        LocationEntity locationEntity1 = new LocationEntity();
//
//        locationEntity1.setLocation("hfghgfh");
//        locationEntity1.setRestaurantLogo("gfhgfhfhf");
//        locationRepository.save(locationEntity1);
//        return "redirect:/admin";
//    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        foodService.deleteProduct(id);
        return "redirect:/admin";
    }

    @GetMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "redirect:/admin";
    }
}

