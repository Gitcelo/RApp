package is.hi.rapp.Controllers.userControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProfileController {
    private UserService userService;

    @RequestMapping("/User/{id}", method = RequestMethod.GET)
    userProfileViewGet(User User) {

    }
}
