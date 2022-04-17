package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface PageService {
    Page save(Page page);
    void delete(Page page);
    List<Page> findAll();
    Page findByID(long id);
    List<Page> findByTitle(String title);
    List<Page> findByUser(User user);
}
