package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Persistence.Repositories.ReviewRepository;
import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) { //Skilar seinna String
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    @Override
    public Review findByID(long id) {
        return reviewRepository.findByID(id);
    }
}
