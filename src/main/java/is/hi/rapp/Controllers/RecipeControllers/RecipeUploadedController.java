package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RecipeUploadedController {
    private RecipeService recipeService;

    @Autowired
    public RecipeUploadedController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/published", method = RequestMethod.GET)
    public String recipeUploadedViewGet(Model model) {
        List<Recipe> publishedRecipes = recipeService.findPublishedRecipes();
        model.addAttribute("recipes", publishedRecipes);
        return "publishedRecipes";
    }
}
