package is.hi.rapp.Controllers.RestControllers;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeRestController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //GET routes
    @RequestMapping(value = "/REST/publishedRecipes", method = RequestMethod.GET)
    public List<Recipe> recipePublished() {
        List<Recipe> publishedRecipes = recipeService.findPublishedRecipes();
        //model.addAttribute("publishedRecipes", publishedRecipes);
        return publishedRecipes;
    }

    @RequestMapping(value = "/REST/randomRecipe", method = RequestMethod.GET)
    public Recipe randomRecipe() {
        long id = recipeService.findRandomId();
        Recipe recipe = recipeService.findByID(id);

        return recipe;
    }

    @RequestMapping(value = "/REST/Recipe/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable long id) {
        Recipe recipe = recipeService.findByID(id);
        return recipe;
    }

    //Viljum við að geta leitað að recipe via title?
    /*@RequestMapping(value = "/REST/searchRecipe", method = RequestMethod.GET)
    public Recipe searchRecipe(@RequestBody String title) {
        Recipe recipe = recipeService.findBySearchBar(title);
        return recipe;
    }*/

    //POST routes
    @RequestMapping(value="/REST/createRecipe", method = RequestMethod.POST)
    public Recipe newRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @RequestMapping(value="REST/editRecipe/{id}", method = RequestMethod.POST)
    public Recipe changeRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    //DELETE routes
    @RequestMapping(value="/REST/deleteRecipe/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable long id, @RequestBody User user) {
        Recipe recipe = recipeService.findByID(id);
        Page page = recipe.getPage();
        User owner = page.getUser();

        if(user.isAdmin() || user.getID() == owner.getID()) {
            recipeService.delete(recipeService.findByID(id));
        }
    }
}