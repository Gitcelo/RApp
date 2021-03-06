package is.hi.rapp.Controllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FrontPageController {
    private final RecipeService recipeService;

    @Autowired
    public FrontPageController(RecipeService recipeService){ this.recipeService = recipeService; }

    @RequestMapping("/")
    public String frontPageController(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        List<Recipe> allRecipes = recipeService.findTrendyRecipes();
        if(allRecipes.isEmpty()) model.addAttribute("recipes", null);
        else model.addAttribute("recipes", allRecipes);
        model.addAttribute("LoggedInUser", sessionUser);
        return "front";
    }
}
