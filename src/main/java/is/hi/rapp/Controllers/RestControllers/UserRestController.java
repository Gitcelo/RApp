package is.hi.rapp.Controllers.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class UserRestController {
    private final UserService userService;
    ObjectMapper mapper = new ObjectMapper();

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

    @RequestMapping(value="/REST/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User loginUser(@RequestBody String input) throws JsonProcessingException {
        JsonNode parsedInput = mapper.readTree(input);
        String username = parsedInput.path("username").asText();
        String password = parsedInput.path("password").asText();

        User exists = userService.findByUserName(username);

        Map<String, String> response;

        if(exists != null) {
            if(exists.getPassword().equals(password)) {
                return exists;
           }
        }
        return new User();
    }
}
