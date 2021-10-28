package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserFollowingController {
    private UserService userService;

    @Autowired
    public UserFollowingController(UserService userService) {
        this.userService = userService;
    }
}
