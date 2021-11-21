package is.hi.rapp.Persistence.Repositories;


import is.hi.rapp.Persistence.Entities.Following;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepository extends JpaRepository<Following, Long> {
    Following save(Following following);
    void delete(Following following);
    List<Following> findByFollower(User follower);
}
