package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RecipeChangeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeChangeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value="/editRecipe/{id}", method = RequestMethod.GET)
    public String recipeChangeViewGet(@PathVariable("id") long id, Model model) {
        Recipe recipeToEdit = recipeService.findByID(id);
        model.addAttribute("recipe", recipeToEdit);
        return "editRecipe";
    }

    @RequestMapping(value="/editRecipe/{id}", method = RequestMethod.POST)
    public String recipeChangeViewPatch(Recipe recipe, @PathVariable("id") long id, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/editRecipe";
        }
        System.out.println(id);
        recipeService.change(id, recipe.getTitle(), recipe.getDescription(), recipe.isPublished());
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteRecipe/{id}", method = RequestMethod.GET)
    public String recipeChangeViewDelete(@PathVariable("id") long id, Model model) {
        Recipe recipeToDelete = recipeService.findByID(id);
        recipeService.delete(recipeToDelete);
        return "redirect:/";
    }

}
