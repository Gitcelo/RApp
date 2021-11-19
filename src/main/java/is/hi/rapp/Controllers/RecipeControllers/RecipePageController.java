package is.hi.rapp.Controllers.RecipeControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
<<<<<<< HEAD
import is.hi.rapp.Persistence.Entities.User;
=======
>>>>>>> recipes
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.ThreadLocalRandom;

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

    @RequestMapping(value="/randomRecipe", method = RequestMethod.GET)
    public String recipeRandomPageViewGet(Model model) {
        System.out.println(recipeService.noOfRows());
        long rowid = ThreadLocalRandom.current().nextLong(recipeService.noOfRows())+1;
        System.out.println("id: " + rowid);
        Recipe randomRecipe =  recipeService.findByRowId(rowid);
        //System.out.println("title: "+randomRecipe.getTitle());
        model.addAttribute("recipe", randomRecipe);
        return "redirect:/recipe";
    }
}
