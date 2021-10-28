package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserChangeController {
    private UserService userService;

    @Autowired
    public UserChangeController(UserService userService) {
        this.userService = userService;
    }
}
