package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeChangeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeChangeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
