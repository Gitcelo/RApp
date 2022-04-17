package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface RecipeService {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe); //Breyta í að skila String
    double calculateAVG(Recipe recipe, long rating);
    List<Recipe> findAll();
    Recipe findByID(long id);
    List<Recipe> findByTitle(String title);
    long findRandomId();
    List<Recipe> findPublishedRecipes();
    List<Recipe> findTrendyRecipes();
    List<Recipe> findBySearchBar(String keyword);
    //List<Recipe> findByUser(User user);
}
