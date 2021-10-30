package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Persistence.Repositories.UserRepository;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User logIn(User user) {
        User doesExist = findByUserName(user.getUserName());
        if(doesExist!=null) {
            if(doesExist.getPassword().equals(user.getPassword())) {
                return doesExist;
            }
        }
        return null;
    }

    public String changePassword(User user, String password, String newPassword) {
        return null;
    }

    public String changeEmail(User user, String newEmail) {
        Long userId = user.getID();
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) { //Munum vilja skila String
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByID(long id) {
        return userRepository.findByID(id);
    }
}
