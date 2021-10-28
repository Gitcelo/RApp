package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProfileController {
    private UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }
}
