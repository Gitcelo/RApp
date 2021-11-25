package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> findAll();
    List<Recipe> findByTitle(String title);
    Recipe findByID(long id);
    List<Recipe> findByUser(User user);

    @Query(nativeQuery = true, value = "SELECT * FROM Recipe r WHERE r.published=true")
    List<Recipe> findPublishedRecipes();

    @Query(nativeQuery = true, value = "SELECT ID FROM Recipe WHERE published=true ORDER BY RANDOM() LIMIT 1")
    long findRandomId();

    @Query(nativeQuery = true, value = "SELECT * FROM Recipe r WHERE r.title LIKE %?1%")
    List<Recipe> findBySearchBar(String keyword);

    @Query(nativeQuery = true, value = "SELECT * FROM Recipe WHERE published=true ORDER BY views DESC LIMIT 5")
    List<Recipe> findTrendyRecipes();
}
