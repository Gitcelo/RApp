package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeSearchController {
    private RecipeService recipeService;

    @Autowired
    public RecipeSearchController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
