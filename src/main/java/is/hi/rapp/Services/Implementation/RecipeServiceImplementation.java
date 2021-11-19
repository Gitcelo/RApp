package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Repositories.RecipeRepository;
import is.hi.rapp.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int updateRecipe(long Id, String title, String description) {
        return recipeRepository.updateRecipe(Id, title, description);
    }
}
