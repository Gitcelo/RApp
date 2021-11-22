package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserCreateController {
    private UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String userCreateViewGet(User user) {
        return "userTemplates/createUser";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String userCreateViewPost(User user, BindingResult result, Model model) {
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
