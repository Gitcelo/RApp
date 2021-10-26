package is.hi.rapp.Persistence.Entities;
import java.util.List;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private List<String> ingredients;
    private boolean published;
    private List<Review> reviews;
    private User user;

    public Recipe() {

    }
    public Recipe(String title, String description, List<String> ingredients) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
    }
}
