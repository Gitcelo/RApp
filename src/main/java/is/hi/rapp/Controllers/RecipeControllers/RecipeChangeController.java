package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import is.hi.rapp.Services.UserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

public class RecipeChangeController {
    private RecipeService recipeService;
    private UserService userService;

    @Autowired
    public RecipeChangeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping(value="/editRecipe", method = RequestMethod.GET)
    public String recipeChangeViewGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser==null) {
            return "redirect:/login";
        }
        model.addAttribute("LoggedInUser", sessionUser);

        return "editRecipe";
    }

}
