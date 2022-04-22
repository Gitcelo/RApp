package is.hi.rapp.Controllers.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@RestController
public class RecipeRestController {
    private final RecipeService recipeService;
    private final PageService pageService;
    private final ObjectMapper mapper = new ObjectMapper();

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

    //Viljum við að geta leitað að recipe via title?
    /*@RequestMapping(value = "/REST/searchRecipe", method = RequestMethod.GET)
    public Recipe searchRecipe(@RequestBody String title) {
        Recipe recipe = recipeService.findBySearchBar(title);
        return recipe;
    }*/

    //POST routes
    @RequestMapping(value="/REST/createRecipe", method = RequestMethod.POST)
    public Recipe newRecipe(@RequestBody String input) throws JsonProcessingException {
        JsonNode parsedInput = mapper.readTree(input);
        JsonNode pageId = parsedInput.get("page_id");
        JsonNode jsonIngredients = parsedInput.get("ingredients");
        List<String> ingredients = new ArrayList<String>();
        for(int i = 0; i < jsonIngredients.size(); i++) {
            String ingredient = jsonIngredients.get(i).asText();
            ingredients.add(ingredient);
        }

        Page page = pageService.findByID(Integer. parseInt(pageId.toString()));
        String title = parsedInput.path("title").asText();
        String description = parsedInput.path("description").asText();
        Boolean published = parsedInput.path("published").asBoolean();

        Recipe recipe = new Recipe(title, description, ingredients, published);
        recipe.setPage(page);
        //recipe.setPage(page);
        return recipeService.save(recipe);
    }

    @RequestMapping(value="REST/editRecipe/{id}", method = RequestMethod.POST)
    public Recipe changeRecipe(@PathVariable long id, @RequestBody String input) throws JsonProcessingException {
        Recipe changeRecipe = recipeService.findByID(id);;
        JsonNode parsedInput = mapper.readTree(input);
        JsonNode jsonIngredients = parsedInput.get("ingredients");
        List<String> ingredients = new ArrayList<String>();
        for(int i = 0; i < jsonIngredients.size(); i++) {
            String ingredient = jsonIngredients.get(i).asText();
            ingredients.add(ingredient);
        }
        String title = parsedInput.path("title").asText();
        String description = parsedInput.path("description").asText();
        Boolean published = parsedInput.path("published").asBoolean();
        changeRecipe.setTitle(title);
        changeRecipe.setDescription(description);
        changeRecipe.setIngredients(ingredients);
        changeRecipe.setPublished(published);
        return recipeService.save(changeRecipe);
    }

    //DELETE routes
    @RequestMapping(value="/REST/deleteRecipe/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable long id, @RequestBody User user) {
//        Recipe recipe = recipeService.findByID(id);
//        Page page = recipe.getPage();
//        User owner = page.getUser();
//
//
//        if(user.isAdmin() || user.getID() == owner.getID()) {
//            recipeService.delete(recipeService.findByID(id));
//        }
        recipeService.delete(recipeService.findByID(id));
    }
}