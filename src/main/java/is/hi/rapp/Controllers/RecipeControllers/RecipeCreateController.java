package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String recipeCreateViewGet(Recipe recipe, User user, HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("LoggedInUser", sessionUser);

        return "createRecipe";
    }

    @RequestMapping(value="/createRecipe", method = RequestMethod.POST)
    public String recipeCreateViewPost(Recipe recipe, User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect:/createRecipe";
        }

        recipeService.save(recipe);

        return "redirect:/";
    }
}
