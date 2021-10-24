package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.User;

public interface UserService {
    User login(String userName, String password);
}
