package ru.sbrf.socialnetwork.objects.model.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 27/11/2016.
 */
public class UserFriends {
    private final long userId;
    private List<Long> friends = new ArrayList<>();

    public UserFriends(long userId) {
        this.userId = userId;
    }

    public void addFriendById(long id) {
        if (id != this.userId)
            this.friends.add(id);
    }

    public void removeFriendById(long id) {
        friends.remove(id);
    }

    public List<Long> getFriends() {
        return Collections.unmodifiableList(friends);
    }
}
