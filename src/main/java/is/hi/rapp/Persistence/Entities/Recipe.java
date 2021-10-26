package is.hi.rapp.Persistence.Entities;
import java.util.List;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private List<String> ingredients;
    private Boolean published;
    private List<Review> reviews;
    private User user;

    public Recipe{

    }
}
