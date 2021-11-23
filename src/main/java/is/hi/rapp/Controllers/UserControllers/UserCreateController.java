package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserCreateController {
    private final UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String userCreateViewGet(@ModelAttribute("user") User user, HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null) {
            return "redirect:/";
        }
        return "userTemplates/createUser";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String userCreateViewPost(@ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/signup";
        }
        User exists = userService.findByUserName(user.getUserName());
        if(exists == null) {
            userService.save(user);
        }
        return "redirect:/";
    }


}
