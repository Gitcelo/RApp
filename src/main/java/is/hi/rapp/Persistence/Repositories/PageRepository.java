package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}
