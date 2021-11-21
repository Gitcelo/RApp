package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Services.RecipeService;
import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewAddController {
    private ReviewService reviewService;
    private RecipeService recipeService;

    @Autowired
    public ReviewAddController(ReviewService reviewService) {
        this.reviewService = reviewService;
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/Recipe", method = RequestMethod.GET)
    public String reviewAddViewGet() {
        return null;
    }


    @RequestMapping(value = "/Recipe/{id}/createReview", method = RequestMethod.POST)
    public String reviewAddViewPost(@PathVariable("id") long id, Review review, HttpSession session, Model model) {

        return "redirect:/Recipe/"+id;
    }
}
