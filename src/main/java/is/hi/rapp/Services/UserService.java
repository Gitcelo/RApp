package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User login(String userName, String password);
    User save(User user);
    void delete(User user); //We return a string instead of nothing to be more RESTful
    List<User> findAll();
    List<User> findByUserName(String userName);
    User findByID(long id);
}
