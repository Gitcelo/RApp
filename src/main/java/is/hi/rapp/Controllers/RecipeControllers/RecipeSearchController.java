package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeSearchController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeSearchController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value="/titleSearch", method = RequestMethod.GET)
    public String recipeSearchByTitleViewGet(@RequestParam("title") String title, Model model) {
        List<Recipe> recipesFound = recipeService.findBySearchBar(title);
        if(recipesFound.isEmpty()) model.addAttribute("recipes", null);
        else model.addAttribute("recipes", recipesFound);
        return "recipeTemplates/recipeSearchResults";
    }
}
