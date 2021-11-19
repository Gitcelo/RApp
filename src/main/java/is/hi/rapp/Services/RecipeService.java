package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe); //Breyta í að skila String
    List<Recipe> findAll();
    Recipe findByID(long id);
    List<Recipe> findByTitle(String title); //Tvær bækur geta haft sama titil
    int updateRecipe(long Id, String title, String description, boolean published);
    //Vantar fleiri aðferðir frá Miro
}
