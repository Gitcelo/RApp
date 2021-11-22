package is.hi.rapp.Controllers.ReviewControllers;

import is.hi.rapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewChangeController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewChangeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @RequestMapping(value = "/Recipe/{id}/Review/{rid}", method = RequestMethod.DELETE)
    public String reviewChangeViewDelete(@PathVariable("id") long id, HttpSession session, Model model) {


        return "redirect:/Recipe/"+id;
    }
    @RequestMapping(value = "/Recipe/{id}/Review/{rid}", method = RequestMethod.POST)
    public String reviewChangeViewPatch(@PathVariable("id") long id, HttpSession session, Model model) {


        return "redirect:/Recipe/"+id;
    }
}
