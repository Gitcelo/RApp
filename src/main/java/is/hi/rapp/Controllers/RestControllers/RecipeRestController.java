package is.hi.rapp.Controllers.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.PageService;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class RecipeRestController {
    private final RecipeService recipeService;
    private final PageService pageService;

    @Autowired
    public RecipeRestController(RecipeService recipeService, PageService pageService) {
        this.recipeService = recipeService;
        this.pageService = pageService;
    }

    //GET routes
    @RequestMapping(value = "/REST/publishedRecipes", method = RequestMethod.GET)
    public List<Recipe> recipePublished() {
        List<Recipe> publishedRecipes = recipeService.findPublishedRecipes();
        //model.addAttribute("publishedRecipes", publishedRecipes);
        return publishedRecipes;
    }

    @Transactional
    @RequestMapping(value = "/REST/randomRecipe", method = RequestMethod.GET)
    public Recipe randomRecipe() {
        long id = recipeService.findRandomId();
        Recipe recipe = recipeService.findByID(id);

        return recipe;
    }
    @Transactional
    @RequestMapping(value="/REST/trending", method = RequestMethod.GET)
    public List<Recipe> recipeTrendyViewGet() {
        List<Recipe> trendyRecipes = recipeService.findTrendyRecipes();
        return trendyRecipes;
    }

    @RequestMapping(value = "/REST/Recipe/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable long id) {
        Recipe recipe = recipeService.findByID(id);
        List<String> test = recipe.getIngredients();
        return recipe;
    }

    //Viljum vi?? a?? geta leita?? a?? recipe via title?
    /*@RequestMapping(value = "/REST/searchRecipe", method = RequestMethod.GET)
    public Recipe searchRecipe(@RequestBody String title) {
        Recipe recipe = recipeService.findBySearchBar(title);
        return recipe;
    }*/

    //POST routes
    @RequestMapping(value="/REST/createRecipe", method = RequestMethod.POST)
    public Recipe newRecipe(@RequestBody Recipe recipe) {
        recipe.getIngredients();
        Page page = pageService.findByID(1);
        recipe.setPage(page);
        return recipeService.save(recipe);
    }

    @RequestMapping(value="REST/editRecipe/{id}", method = RequestMethod.POST)
    public Recipe changeRecipe(@PathVariable long id, @RequestBody String input) throws JsonProcessingException {
        Recipe changeRecipe = recipeService.findByID(id);
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(input, Recipe.class);
        changeRecipe.setTitle(recipe.getTitle());
        changeRecipe.setDescription(recipe.getDescription());
        changeRecipe.setIngredients(recipe.getIngredients());
        changeRecipe.setPublished(recipe.isPublished());
        return recipeService.save(changeRecipe);
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