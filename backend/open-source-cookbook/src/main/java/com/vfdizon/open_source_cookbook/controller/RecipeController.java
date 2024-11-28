package com.vfdizon.open_source_cookbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vfdizon.open_source_cookbook.model.Recipe;
import com.vfdizon.open_source_cookbook.repository.RecipeRepository;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping("/recipes")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
             


}
