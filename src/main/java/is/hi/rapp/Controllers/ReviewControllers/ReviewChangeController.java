package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewChangeController {
    private ReviewService reviewService;

    @Autowired
    public ReviewChangeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
