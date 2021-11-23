package is.hi.rapp.Persistence.Entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String title;
    private String description;
    @ElementCollection
    private List<String> ingredients;
    private boolean published;
    private double avgRating;

    @OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Recipe() {

    }

    public Recipe(String title, String description, List<String> ingredients, boolean published) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.published = published;
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setAvgRating(double avgRating) { this.avgRating = avgRating; }

    public double getAvgRating() { return avgRating; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
