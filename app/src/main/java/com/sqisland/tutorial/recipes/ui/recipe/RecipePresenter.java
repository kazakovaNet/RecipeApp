package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter implements RecipeContract.Listener{
    private final RecipeStore store;
    private RecipeContract.View view;
    private Favorites favorites;
    private Recipe recipe;
    
    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }
    
    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(recipe.id));
        }
    }
    
    public void toggleFavorite() {
        boolean result = favorites.toggle(recipe.id);
        view.setFavorite(result);
    }
}
