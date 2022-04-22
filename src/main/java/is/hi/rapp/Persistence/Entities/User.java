package is.hi.rapp.Persistence.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String userName;
    private String email;
    private String password;
    private boolean admin;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    /*@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes;

    @OneToMany(mappedBy = "follower",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Following> followings;*/

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;

    public User() {}

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        //this.recipes = recipes;
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

    public List<Page> getPages() { return pages; }

    public void setPages(List<Page> pages) { this.pages = pages; }

    //public List<Recipe> getRecipes() { return recipes; }

    //public List<Following> getFollowings() { return followings; }

    public boolean getAdmin() { return admin; }

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

    //public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }

    public void setAdmin(boolean admin) { this.admin = admin; }

    //public void setFollowings(List<Following> followings) { this.followings = followings; }
}
