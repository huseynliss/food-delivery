package com.example.foodprojectmain.controller;

import com.example.foodprojectmain.dao.entity.user.User;
import com.example.foodprojectmain.service.FoodService;
import com.example.foodprojectmain.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {


    private final FoodService foodService;
    private final LocationService locationService;

    public IndexController(FoodService foodService, LocationService locationService) {
        this.foodService = foodService;
        this.locationService = locationService;
    }

    @GetMapping
    public String showIndexPage(Model model){


        model.addAttribute("FirstFivePopularItems", foodService.getFirstFourPopularItems());
        model.addAttribute("SecondFivePopularItems", foodService.getSecondFourPopularItems());
        model.addAttribute("FirstRestaurants", locationService.getFirstRestaurants());
        model.addAttribute("SecondRestaurants", locationService.getSecondRestaurants());

        return "index";
    }

    @GetMapping(value = {"/search-results", "/search-results/{name}"})
    public String showSearchResult(@PathVariable(value = "name", required = false) String name, Model model){
        model.addAttribute("allProducts", foodService.getAllProducts());

        if (name != null){
            model.addAttribute("productName", name);
        }
        return "search-results";
    }

    @GetMapping("/add-to-cart")
    public String showCart(Model model) {
        model.addAttribute("allProducts", foodService.getAllProducts());

        return "add-to-cart";
    }




}
