package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Persistence.Repositories.RecipeRepository;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImplementation implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImplementation(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe); //Þarf að verða return þegar delete skilar String
    }

    @Override
    public double calculateAVG(Recipe recipe, long rating) {
        long numberOfReviews = recipe.getReviews().size();
        double totalRating = recipe.getAvgRating() * numberOfReviews;
        totalRating = totalRating + rating;
        return totalRating/(numberOfReviews+1);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findByID(long id) {
        return recipeRepository.findByID(id);
    }

    @Override
    public List<Recipe> findByTitle(String title) {
        return recipeRepository.findByTitle(title);
    }

    @Override
    public long findRandomId() {
        return recipeRepository.findRandomId();
    }

    @Override
    public List<Recipe> findPublishedRecipes() {
        return recipeRepository.findPublishedRecipes();
    }

    @Override
    public List<Recipe> findTrendyRecipes() {
        return recipeRepository.findTrendyRecipes();
    }

    @Override
    public List<Recipe> findBySearchBar(String keyword) {
        String[] splitKeyword = keyword.trim().split("\\s+");
        List<Recipe> recipes = new ArrayList<Recipe>();

        for(int i = 0; i < splitKeyword.length; i++) {
            List<Recipe> test = recipeRepository.findBySearchBar(splitKeyword[i]);
            for(Recipe pls : test) {
                if(!recipes.contains(pls)) {
                    recipes.add(pls);
                }
            }
        }

        return recipes;
        //return recipeRepository.findBySearchBar(keyword);
    }

    @Override
    public List<Recipe> findByUser(User user) {
        return recipeRepository.findByUser(user);
    }
}
