package is.hi.rapp.Controllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserCreateController {
    private UserService userService;

    @RequestMapping("/addUser")
        public String userCreatePage(Model model) {
        // Call a method in a Service Class
        //List<User> allUsers = userService.findAll();
        // Add some data to the model
        model.addAttribute("users", allUsers);
        return "CreateUser";
    }

    @RequestMapping(value="/user/delete/{id}", method= RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id, Model model) {
        return "redirect:/";
    }
}
