package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> findAll();
    List<Recipe> findByTitle(String title);
    Recipe findByID(long id);
}
