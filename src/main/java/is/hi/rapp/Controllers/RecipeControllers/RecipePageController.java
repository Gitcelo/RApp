package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipePageController {
    private RecipeService recipeService;

    @Autowired
    public RecipePageController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/Recipe/{id}", method = RequestMethod.GET)
    public String userProfileViewGet(@PathVariable("id") long id, Model model) {
        Recipe recipeToView =  recipeService.findByID(id);
        model.addAttribute("recipe", recipeToView);
        return "recipe";
    }
}
