package is.hi.rapp.Persistence.Entities;

public class Review {
    private long id;
    private String description;
    private boolean liked;
    private User user;
    private Recipe recipe;

    public Review() {

    }
    public Review(String description, boolean liked) {
        this.description = description;
        this.liked = liked;

    }

    public long getId() {
        return id;
    }

    public boolean isLiked() {
        return liked;
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
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
