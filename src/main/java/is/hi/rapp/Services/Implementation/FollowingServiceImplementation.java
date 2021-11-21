package is.hi.rapp.Services.Implementation;


import is.hi.rapp.Persistence.Entities.Following;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Persistence.Repositories.FollowingRepository;
import is.hi.rapp.Services.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingServiceImplementation implements FollowingService {
    private final FollowingRepository followingRepository;

    @Autowired
    public FollowingServiceImplementation(FollowingRepository followingRepository) {this.followingRepository = followingRepository;}

    @Override
    public List<Following> findByFollower(User follower) {return followingRepository.findByFollower(follower);}
}
