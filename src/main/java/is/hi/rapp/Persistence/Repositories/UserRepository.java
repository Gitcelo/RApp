package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User login(String userName, String password);
    @Query("UPDATE users SET email = ?2 WHERE ID = ?1")
    String changeEmail(User user, String newEmail);
    User save(User user);
    void delete(User user); //We return a string instead of nothing to be more RESTful
    List<User> findAll();
    List<User> findByUserName(String userName);
    User findByID(long id);
}
