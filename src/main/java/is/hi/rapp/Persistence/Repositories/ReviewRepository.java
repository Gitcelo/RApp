package is.hi.rapp.Persistence.Repositories;

import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review save(Review review);
    void delete(Review review); //Breyta svo í að skila String
    List<Review> findAll();
    List<Review> findByUser(User user);
    Review findByID(long id);
    // Setja svo inn restina af aðferðunum
}
