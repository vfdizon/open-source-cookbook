import { useState, useEffect } from "react";
import { getRecipes, saveRecipe } from "../services/apiService";

function RecipeComponent() {
    const [recipes, setRecipes] = useState([]);

    const [recipeName, setRecipeName] = useState('');
    const [recipeAuthor, setRecipeAuthor] = useState('');
    const [recipeOrigins, setRecipeOrigins] = useState([]);
    const [servingAmount, setServingAmount] = useState(0);
    const [ingredients, setIngredients] = useState([]);
    const [instructions, setInstructions] = useState([]);

    useEffect(() => {
        fetchRecipes();
    }, []);

    const fetchRecipes = async () => {
        try {
            // const data = await getRecipes();
            // setRecipes(data);
        } catch (error) {
            console.error('Failed to fetch Recipes: ', error);
        }
    }; 

    const handleSaveRecipe = async () => {
        try {
            saveRecipe({
                name: recipeName,
                author: recipeAuthor,
                origins: recipeOrigins,
                servingAmount: servingAmount,
                ingredients: ingredients,
                instructions: instructions
            });
            // fetchRecipes();
            // setNewRecipe({});
        } catch (error) {
            console.error('Failed to save Recipe: ', error);
        }
    }

    return (
        <div>
            <h1> Recipes </h1>
            <ul>
                {recipes.map((recipe, index) => (
                    <li key={index}>
                        <h2>{recipe.name}</h2>
                        <p>{recipe.author}</p>
                        <p>{recipe.origins}</p>
                        <p>{recipe.servingAmount}</p>
                        <p>{recipe.ingredients}</p>
                        <p>{recipe.instructions}</p>
                    </li>
                ))}
            </ul>

            <h2> Add Recipe </h2>
            <input type="text" placeholder="Recipe Name" value={recipeName} onChange={(e) => setRecipeName(e.target.value)} />
            <input type="text" placeholder="Recipe Author" value={recipeAuthor} onChange={(e) => setRecipeAuthor(e.target.value)} />
            <input type="text" placeholder="Recipe Origins" value={recipeOrigins} onChange={(e) => {
                const origins = e.target.value.split(',');
                setRecipeOrigins(origins);
            }} />
            <input type="number" placeholder="Serving Amount" value={servingAmount} onChange={(e) => setServingAmount(e.target.value)} />
            <input type="text" placeholder="Ingredients"  onChange={(e) => setIngredients(parseIngredients(e.target.value))} />
            <input type="text" placeholder="Instructions"  onChange={(e) => setInstructions(e.target.value.split(","))} />
            <button onClick={handleSaveRecipe}> Save Recipe </button>   
        </div>
    );
}

function parseIngredients(ingredients) {
    let ret_val = [];
    let ingredientsArray = ingredients.split(',');
    ingredientsArray.forEach((ingredientData, _) => {
        let ingredientArray = ingredientData.split(':');
        ret_val.push({
            amount: ingredientArray[0],
            measurement: ingredientArray[1],
            ingredient: ingredientArray[2]
        });
    });
    return ret_val;
}

export default RecipeComponent