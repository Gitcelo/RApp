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

    @RequestMapping(value="/editRecipe", method = RequestMethod.GET)
    public String recipeChangeViewPost(Recipe recipe, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "redirect:/editRecipe";
        }
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        recipe.setUser(sessionUser);
        recipeService.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getDescription());
        System.out.println("edited");
        return "redirect:/";
    }

}
