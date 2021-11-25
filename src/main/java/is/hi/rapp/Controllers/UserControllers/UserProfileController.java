package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserProfileController {
    private final UserService userService;

    @Autowired
    public UserProfileController(UserService userService){ this.userService = userService; }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
    public String userProfileViewGet(@PathVariable("id") long id, Model model, HttpSession session) {
        User userToView =  userService.findByID(id);
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("LoggedInUser", sessionUser);
        model.addAttribute("user", userToView);
        return "userTemplates/user";
    }
}
