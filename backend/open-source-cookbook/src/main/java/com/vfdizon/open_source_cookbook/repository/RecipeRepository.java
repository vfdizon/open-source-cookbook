package com.vfdizon.open_source_cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vfdizon.open_source_cookbook.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Long> {

    
}