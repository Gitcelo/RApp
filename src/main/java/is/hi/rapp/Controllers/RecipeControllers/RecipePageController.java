package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecipePageController {
    private RecipeService recipeService;

    @Autowired
    public RecipePageController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/Recipe/{id}", method = RequestMethod.GET)
    public String recipeViewGet(@ModelAttribute("review") Review review, @PathVariable("id") long id, HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("LoggedInUser", sessionUser);
        model.addAttribute("recipe", recipeService.findByID(id));
        return "recipe";
    }

    @RequestMapping(value="/randomRecipe", method = RequestMethod.GET)
    public String recipeRandomPageViewGet() {
        long id = recipeService.findRandomId();
        return "redirect:/Recipe/" + id;
    }

    @RequestMapping(value="/publishedRecipes", method = RequestMethod.GET)
    public String recipePublishedPageViewGet(Model model) {
        List<Recipe> publishedRecipes = recipeService.findPublishedRecipes();
        model.addAttribute("publishedRecipes", publishedRecipes);
        return "redirect:/publishedRecipes";
    }
}
