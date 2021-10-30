package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewAddController {
    private ReviewService reviewService;

    @Autowired
    public ReviewAddController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
