package com.paf.socialmedia.controller;

import com.paf.socialmedia.repository.mealplan.SearchRepository;
import com.paf.socialmedia.dto.MealPlanDTO;
import com.paf.socialmedia.repository.mealplan.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mealplan")
public class MealPlanController {
    @Autowired
    MealPlanRepository repo;

    @Autowired
    SearchRepository srepo;


    @GetMapping("/allMeals")
    @CrossOrigin
    public List<MealPlanDTO> getAllPosts()
    {
        return repo.findAll();
    }
    // posts/java
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<MealPlanDTO> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @PostMapping("/")
    @CrossOrigin
    public MealPlanDTO addMealPlan(@RequestBody MealPlanDTO post)
    {
        return repo.save(post);
    }
}
