package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    Page save(Page page);
    void delete(Page page);
    List<Page> findAll();
    List<Page> findByTitle(String title);
    Page findByID(long id);
    List<Page> findByUser(User user);

    @Query(nativeQuery = true, value = "SELECT * FROM Page p WHERE p.title LIKE %?1%")
    List<Page> findBySearchBar(String keyword);

    @Query(nativeQuery = true, value = "SELECT * FROM Page p LIMIT :limit")
    List<Page> findFourPages(@Param("limit") long limit);

    @Query(nativeQuery = true, value = "SELECT user_id FROM Page p WHERE p.id = :pageid")
    long findUserId(@Param("pageid") long pageid);
}
