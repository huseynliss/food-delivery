package com.example.foodprojectmain.controller;

import com.example.foodprojectmain.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    private FoodService foodService;

    public IndexController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String showIndexPage(Model model){
        model.addAttribute("FirstFivePopularItems", foodService.getFirstFourPopularItems());
        model.addAttribute("SecondFivePopularItems", foodService.getSecondFourPopularItems());
        model.addAttribute("FirstRestaurants", foodService.getFirstRestaurants());
        model.addAttribute("SecondRestaurants", foodService.getSecondRestaurants());



        return "index";
    }
    @GetMapping("/search-results")
    public String showSearchResult(Model model){
        model.addAttribute("AllProducts", foodService.getAllProducts());
        model.addAttribute("FirstFivePopularItems", foodService.getFirstFourPopularItems());
        return "search-results";
    }





}
