package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeUploadController {
    private RecipeService recipeService;

    @Autowired
    public RecipeUploadController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
