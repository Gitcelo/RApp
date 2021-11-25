package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User logIn(User user);
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUserName(String userName);
    User findByID(long id);
}
