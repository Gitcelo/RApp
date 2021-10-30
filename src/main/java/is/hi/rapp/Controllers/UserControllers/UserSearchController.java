package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSearchController {
    private UserService userService;

    @Autowired
    public UserSearchController(UserService userService) {
        this.userService = userService;
    }
}
