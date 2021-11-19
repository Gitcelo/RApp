package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewAddController {
    private ReviewService reviewService;

    @Autowired
    public ReviewAddController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
