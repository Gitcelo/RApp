package is.hi.rapp.Controllers.UserControllers;

import is.hi.rapp.Persistence.Entities.Following;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserFollowingController {
    private final FollowingService followingService;

    @Autowired
    public UserFollowingController(FollowingService followingService) {this.followingService = followingService;}

    @RequestMapping(value = "/following", method = RequestMethod.GET)
    public String userFollowingViewGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser!=null) {
            List<Following> followings = followingService.findByFollower(sessionUser);
            if(followings.isEmpty()) model.addAttribute("followings", null);
            else model.addAttribute("followings", followings);
            return "userTemplates/following";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public String userFollowPost(Following follow, HttpSession session) {
        User follower = (User) session.getAttribute("LoggedInUser");
        follow.setFollower(follower);
        followingService.save(follow);
        return "redirect:/following";
    }

    @RequestMapping(value = "unfollow", method = RequestMethod.POST)
    public String userUnfollowPost(Following follow) {
        followingService.delete(follow);
        return "redirect:/following";
    }
}
