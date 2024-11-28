import axios from 'axios';

const API_URL = "http://localhost:8080";

export const getRecipes = async () => {
    try {
        const response = await axios.get(`${API_URL}/recipes`);
        return response.data;
    } catch (error) {
        console.error('Error fetching message', error);
        throw error;
    }
};

export const saveRecipe = async (content) => {
    try {
        const response = await axios.post(`${API_URL}/recipes`, content);
        return response.data;
    } catch (error) {
        console.error('Error saving message', error);
        throw error;
    }
}