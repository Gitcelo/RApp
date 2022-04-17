package is.hi.rapp.Persistence.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Following {
    @Id
    private long followedPageId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User follower;

    public Following() {}

    public Following(long followedUserId, User follower) {
        this.followedPageId = followedUserId;
        this.follower = follower;
    }

    public long getFollowedUserId() {
        return followedPageId;
    }

    public void setFollowedUserId(long followedUserId) { this.followedPageId = followedUserId; }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
