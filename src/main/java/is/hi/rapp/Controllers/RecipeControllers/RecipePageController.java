package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipePageController {
    private RecipeService recipeService;

    @Autowired
    public RecipePageController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
