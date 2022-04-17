package is.hi.rapp.Controllers.RestControllers;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PageRestController {
    private final PageService pageService;

    @Autowired
    public PageRestController(PageService pageService) {
        this.pageService = pageService;
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
    public Page newPage(@RequestBody Page page) {
        return pageService.save(page);
    }

    @RequestMapping(value="/REST/page/{id}", method = RequestMethod.POST)
    public Page changePage(@PathVariable long id, @RequestBody Page page) {
        return pageService.save(page);
    }
}
