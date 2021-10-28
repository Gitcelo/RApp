package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeCreateController {
    private RecipeService recipeService;

    @Autowired
    public RecipeCreateController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
