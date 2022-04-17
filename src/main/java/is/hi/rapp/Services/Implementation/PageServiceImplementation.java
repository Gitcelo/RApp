package is.hi.rapp.Services.Implementation;

import is.hi.rapp.Persistence.Entities.Page;
import is.hi.rapp.Persistence.Entities.User;
import is.hi.rapp.Persistence.Repositories.PageRepository;
import is.hi.rapp.Services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImplementation implements PageService {
    private final PageRepository pageRepository;

    @Autowired
    public PageServiceImplementation(PageRepository pageRepository) { this.pageRepository = pageRepository; }

    @Override
    public Page save(Page page) { return pageRepository.save(page); }

    @Override
    public void delete(Page page) {
        pageRepository.delete(page);
    }

    @Override
    public List<Page> findAll() { return pageRepository.findAll(); }

    @Override
    public Page findByID(long id) { return pageRepository.findByID(id); }

    @Override
    public List<Page> findByTitle(String title) { return pageRepository.findByTitle(title); }

    @Override
    public List<Page> findByUser(User user) { return pageRepository.findByUser(user); }

}
