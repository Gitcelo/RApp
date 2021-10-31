package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserCreateController {
    private UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/createUser", method = RequestMethod.GET)
    public String userCreateViewGet(User user) {
        return "createUser";
    }

    @RequestMapping(value="/createUser", method = RequestMethod.POST)
    public String userCreateViewPost(User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect:/createUser";
        }
        User exists = userService.findByUserName(user.getUserName());
        if(exists == null) {
            userService.save(user);
        }
        return "redirect:/";
    }


}
