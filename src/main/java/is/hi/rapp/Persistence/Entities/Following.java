package is.hi.rapp.Persistence.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Following {
    @Id
    private long followedUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User follower;

    public Following() {}

    public Following(long followedUserId, User follower) {
        this.followedUserId = followedUserId;
        this.follower = follower;
    }

    public long getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(long followedUserId) { this.followedUserId = followedUserId; }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
