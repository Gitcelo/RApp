package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserSearchController {
    private final UserService userService;

    @Autowired
    public UserSearchController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/Users", method = RequestMethod.GET)
    public String userSearchViewGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        List<User> allUsers = userService.findAll();
        model.addAttribute("LoggedInUser", sessionUser);
        model.addAttribute("Users", allUsers);

        return "userTemplates/users";
    }
}
