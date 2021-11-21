package is.hi.rapp.Services;


import is.hi.rapp.Persistence.Entities.Following;
import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface FollowingService {
    Following save(Following following);
    void delete(Following following);
    List<Following> findByFollower(User follower);
}
