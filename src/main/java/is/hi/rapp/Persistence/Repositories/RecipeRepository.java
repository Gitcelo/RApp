package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> findAll();
    List<Recipe> findByTitle(String title);
    Recipe findByID(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM Recipe r WHERE r.published=true")
    List<Recipe> findPublishedRecipes();

    @Query(nativeQuery = true, value = "SELECT ID FROM Recipe ORDER BY RANDOM() LIMIT 1")
    long findRandomId();
}
