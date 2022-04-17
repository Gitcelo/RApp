package is.hi.rapp.Controllers.RestControllers;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //GET routes
    @RequestMapping(value="/REST/Users", method = RequestMethod.GET)
    public List<User> allUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @RequestMapping(value="/REST/User/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        User user = userService.findByID(id);
        return user;
    }

    //þarf að útfæra login

    //POST routes

    //breyta return gildum kannski
    @RequestMapping(value="/REST/signup", method = RequestMethod.POST)
    public boolean createUser(@RequestBody User user) {
        User exists = userService.findByUserName(user.getUserName());
        if(exists == null) {
            userService.save(user);
            return true;
        }
        return false;
    }
}
