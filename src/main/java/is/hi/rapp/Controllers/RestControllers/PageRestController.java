package is.hi.rapp.Controllers.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Services.PageService;
import is.hi.rapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PageRestController {
    private final PageService pageService;
    private final UserService userService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public PageRestController(PageService pageService, UserService userService) {
        this.pageService = pageService;
        this.userService = userService;
    }

    @RequestMapping(value="/REST/pages", method = RequestMethod.GET)
    public List<Page> getPages() {
        List<Page> pages = pageService.findAll();
        return pages;
    }

    @RequestMapping(value="/REST/page/{id}", method = RequestMethod.GET)
    public Page getPage(@PathVariable long id) {
        Page page = pageService.findByID(id);
        return page;
    }

    @RequestMapping(value="/REST/createPage", method = RequestMethod.POST)
    public Page newPage(@RequestBody String input) throws JsonProcessingException {
        JsonNode parsedInput = mapper.readTree(input);
        String username = parsedInput.path("userName").asText();
        String title = parsedInput.path("title").asText();
        String description = parsedInput.path("description").asText();
        User user = userService.findByUserName(username);
        Page page = new Page(title, description);
        page.setUser(user);

        pageService.save(page);

        return page;
    }

    @RequestMapping(value="/REST/page/{id}", method = RequestMethod.POST)
    public Page changePage(@PathVariable long id, @RequestBody Page page) {
        return pageService.save(page);
    }

    @RequestMapping(value="/REST/userPages/{username}", method = RequestMethod.GET)
    public List<Page> getPagesByUsername(@PathVariable String username) {
        User user = userService.findByUserName(username);
        return pageService.findByUser(user);
    }

    @RequestMapping(value="/REST/pages/{id}", method = RequestMethod.GET)
    public Page getPageByUserId(@PathVariable long id) { return pageService.findByID(id); }
}
