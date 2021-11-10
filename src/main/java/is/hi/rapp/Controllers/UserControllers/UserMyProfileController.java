package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserMyProfileController {
    private UserService userService;

    @Autowired
    public UserMyProfileController(UserService userService){ this.userService = userService; }

    @RequestMapping(value = "/LoggedInUser", method = RequestMethod.GET)
    public String userProfileViewGet(HttpSession session, Model model) {

        User sessionUser = (User) session.getAttribute("LoggedInUser");

        if(sessionUser != null) {
            model.addAttribute("LoggedInUser", sessionUser);

            return "LoggedInUser";
        }

        return "redirect:/";
    }
}
