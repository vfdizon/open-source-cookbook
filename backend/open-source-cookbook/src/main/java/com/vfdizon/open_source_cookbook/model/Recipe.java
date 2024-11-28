package com.vfdizon.open_source_cookbook.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String author;
    private List<String> origins;
    private double servingAmount;
    @ElementCollection
    private List<IngredientData> ingredients;
    private List<String> instructions; 

    public Recipe() {}

    public Recipe(String name, String author, List<String> origins, double servingAmount, List<IngredientData> ingredients, List<String> instructions) {
        this.name = name;
        this.author = author;
        this.origins = origins;
        this.servingAmount = servingAmount;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String newID) {
        id = newID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public List<String> getOrigins() {
        return origins;
    }

    public void setOrigins(List<String> newOrigins) {
        origins = newOrigins;
    }

    public double getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(double newServingAmount) {
        servingAmount = newServingAmount;
    }

    public List<IngredientData> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientData> newIngredients) {
        ingredients = newIngredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> newInstructions) {
        instructions = newInstructions;
    }
}
