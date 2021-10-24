package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private List<User> userRepository = new ArrayList<>(); // dummy repository
    private int id_counter = 0;

    @Autowired
    public UserServiceImplementation() {
        // Create 3 random users for our dummy repo. To be removed when JPA added.
        List<Review> reviews = new ArrayList<>();
        List<Recipe > recipes = new ArrayList<>();
        List<String> following = new ArrayList<>();
        userRepository.add(new User("MarzukIngi", "mil4@hi.is", "pabbaskrágur", reviews, recipes, following));
        userRepository.add(new User("Gitcelo", "mfa5@hi.is", "líkapabbaskrágur", reviews, recipes, following));
        userRepository.add(new User("Steinunng", "sgk6@hi.is", "mestipabbaskrágur", reviews, recipes, following));
        // JPA gives each user an ID but here we add them manually
        for(User u: userRepository) {
            u.setID(id_counter++);
        }
    }


    @Override
    public User login(String userName, String password) {
        return null;
    }
}
