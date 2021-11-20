package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> findAll();
    List<Recipe> findByTitle(String title);
    Recipe findByID(long id);

    @Transactional
    @Modifying

    @Query("UPDATE Recipe r SET r.title = :title, r.description = :description, r.published = :published WHERE r.ID = :ID")
    int change(@Param("ID") long ID, @Param("title") String title, @Param("description") String description,
                     @Param("published") boolean published);

    @Query(nativeQuery = true, value = "SELECT ID FROM Recipe ORDER BY RANDOM() LIMIT 1")
    long findRandomId();
}
