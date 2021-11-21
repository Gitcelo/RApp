package is.hi.rapp.Persistence.Repositories;


import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepository extends JpaRepository<Recipe, Long> {
    //List<Following> findByFollower(User follower);
}
