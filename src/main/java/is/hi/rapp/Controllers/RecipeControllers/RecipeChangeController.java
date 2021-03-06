package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Page;
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
    private final RecipeService recipeService;

    @Autowired
    public RecipeChangeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value="/editRecipe/{id}", method = RequestMethod.GET)
    public String recipeChangeViewGet(@PathVariable("id") long id, Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("LoggedInUser", sessionUser);
        Recipe recipeToEdit = recipeService.findByID(id);
        model.addAttribute("recipe", recipeToEdit);
        return "recipeTemplates/editRecipe";
    }

    @RequestMapping(value="/editRecipe/{id}", method = RequestMethod.POST)
    public String recipeChangeViewPatch(Recipe recipe, @PathVariable("id") long id, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/editRecipe";
        }
        Recipe recipeToChange = recipeService.findByID(id);
        recipeToChange.setTitle(recipe.getTitle());
        recipeToChange.setDescription(recipe.getDescription());
        recipeToChange.setIngredients(recipe.getIngredients());
        recipeToChange.setPublished(recipe.isPublished());
        recipeService.save(recipeToChange);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteRecipe/{id}", method = RequestMethod.GET)
    public String recipeChangeViewDelete(@PathVariable("id") long id, HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        //Sko??a seinna
        Recipe recipe = recipeService.findByID(id);
        Page page = recipe.getPage();
        User owner = page.getUser();

        if(sessionUser.isAdmin() || sessionUser.getID() == owner.getID()) {
            recipeService.delete(recipeService.findByID(id));
        }
        return "redirect:/";
    }

}
