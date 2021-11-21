package is.hi.rapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
    @Autowired
    public ErrorController() {}

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorViewGet() {
        return "error";
    }
}
