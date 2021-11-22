package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Persistence.Entities.Recipe;
import is.hi.rapp.Persistence.Entities.Review;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.RecipeService;
import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewAddController {
    private final ReviewService reviewService;
    private final RecipeService recipeService;

    @Autowired
    public ReviewAddController(ReviewService reviewService, RecipeService recipeService) {
        this.reviewService = reviewService;
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/Recipe/{id}/createReview", method = RequestMethod.GET)
    public String reviewAddViewGet() {
        return null;
    }


    @RequestMapping(value = "/Recipe/{id}/createReview", method = RequestMethod.POST)
    public String reviewAddViewPost(@ModelAttribute("review") Review review,
                                    BindingResult result,
                                    @PathVariable("id") long id,
                                    HttpSession session) {
        Recipe recipe = recipeService.findByID(id);
        if(result.hasErrors()) {
            return "redirect:/Recipe"+id;
        }
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        //Recipe currentRecipe = recipeService.findByID(id);
        review.setUser(sessionUser);
        review.setRecipe(recipe);
        reviewService.save(review);

        return "redirect:/Recipe/"+id;
    }
}
