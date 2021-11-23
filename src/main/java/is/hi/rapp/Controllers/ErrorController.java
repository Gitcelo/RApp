package is.hi.rapp.Controllers;

import is.hi.rapp.Persistence.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ErrorController {
    @Autowired
    public ErrorController() {}

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorViewGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("LoggedInUser", sessionUser);
        return "error";
    }
}
