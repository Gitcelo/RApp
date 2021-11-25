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
public class UserChangeController {
    private final UserService userService;

    @Autowired
    public UserChangeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/LoggedInUser", method = RequestMethod.PATCH)
    public String UserChangeViewPatch(User user, String password, String newPassword, String newEmail, Model model) {
        User userToChange = userService.findByID(user.getID());

        if(password.equals(userToChange.getPassword())) {
            if(newPassword != null) {
                userToChange.setPassword(newPassword);
            }

            if(newEmail != null) {
                userToChange.setEmail(newEmail);
            }
        }

        return "userTemplates/LoggedInUser";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String UserChangeViewDelete(@PathVariable("id") long id, HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        User userToDelete = userService.findByID(id);

        if(sessionUser.getAdmin() == true) {
            userService.delete(userToDelete);
            return "redirect:/users";
        }
        return "redirect:/";
    }
}
