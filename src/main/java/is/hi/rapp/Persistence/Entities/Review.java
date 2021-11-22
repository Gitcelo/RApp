package is.hi.rapp.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String description;
    private long rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    public Review() {

    }

    public Review(String description, long rating) {
        this.description = description;
        this.rating = rating;
    }

    public long getId() {
        return ID;
    }

    public long getRating() {
        return rating;
    }


    public String getDescription(){
        return description;
    }

    public User getUser(){
        return user;
    }

    public Recipe getRecipe(){
        return recipe;
    }


    public void setId(long id) {
        this.ID = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLiked(long rating) {
        this.rating = rating;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
