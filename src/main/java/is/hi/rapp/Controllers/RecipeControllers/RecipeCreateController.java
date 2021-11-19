package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RecipeCreateController {
    private RecipeService recipeService;
    private UserService userService;

    @Autowired
    public RecipeCreateController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping(value="/createRecipe", method = RequestMethod.GET)
    // @ModelAttribute leyfir okkur að taka inn recipe án þess að þurfa að nota það.
    // Ef við tökum þetta ekki inn þá kastar forritið villu.
    public String recipeCreateViewGet(@ModelAttribute("recipe") Recipe recipe, HttpSession session) { // Kannski taka inn model kannski ekki
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser == null) {
            return "redirect:/login";
        }
        return "createRecipe";
    }

    @RequestMapping(value="/createRecipe", method = RequestMethod.POST)
    public String recipeCreateViewPost(Recipe recipe, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "redirect:/createRecipe";
        }
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        recipe.setUser(sessionUser);
        recipeService.save(recipe);
        // User test = userService.findByID(sessionUser.getID());
        // System.out.println(test.getRecipes());
        return "redirect:/";
    }
}
