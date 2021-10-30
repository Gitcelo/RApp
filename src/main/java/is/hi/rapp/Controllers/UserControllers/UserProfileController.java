package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProfileController {
    private UserService userService;

    @RequestMapping("/User/{id}", method = RequestMethod.GET)
    public String userProfileViewGet(@PathVariable("id") long id, Model model) {
        User userToView =  userService.findOne(id);

        model.addAttribute("user", userToView)
    }
}
