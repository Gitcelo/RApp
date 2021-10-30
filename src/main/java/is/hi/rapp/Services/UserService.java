package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User logIn(User user);
    String changePassword(User user, String password, String newPassword);
    String changeEmail(User user, String newEmail);
    User save(User user);
    void delete(User user); //We return a string instead of nothing to be more RESTful
    List<User> findAll();
    User findByUserName(String userName);
    User findByID(long id);
}
