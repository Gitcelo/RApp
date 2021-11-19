package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecipeUploadController {
    private RecipeService recipeService;

    @Autowired
    public RecipeUploadController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
