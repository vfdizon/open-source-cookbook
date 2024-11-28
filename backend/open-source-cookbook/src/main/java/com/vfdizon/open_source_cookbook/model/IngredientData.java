package com.vfdizon.open_source_cookbook.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class IngredientData {
    private double amount;
    private String measurement;
    private String ingredient;
    
    public IngredientData() {}

    public IngredientData(double amount, String measurement, String ingredient) {
        this.amount = amount;
        this.measurement = measurement;
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double newAmount) { 
        amount = newAmount;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String newIngredient) {
        ingredient = newIngredient;
    }
}
