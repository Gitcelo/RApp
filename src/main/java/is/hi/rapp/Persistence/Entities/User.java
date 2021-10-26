package is.hi.rapp.Persistence.Entities;

import java.util.List;

public class User {
    private long ID;
    private String userName;
    private String email;
    private String password;
    private List<Review> reviews;
    private List<Recipe> recipes;
    private List<String> following;

    public User() {

    }

    public User(String userName, String email, String password, List<Review> reviews, List<Recipe> recipes, List<String> following) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.reviews = reviews;
        this.recipes = recipes;
        this.following = following;
    }

    public long getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }
}
