package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository {
    User save(User user);
    String delete(User user); //We return a string instead of nothing to be more RESTful
    @SQL
    String changePassword(User user, String password, String newPassword);

    List<User> findAll();
    List<User> findByTitle(String title);
    User findByID(long id);
}
