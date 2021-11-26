package is.hi.rapp.Services;

import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    void delete(Review review);
    List<Review> findAll();
    List<Review> findByUser(User user);
    Review findByID(long id);
}
