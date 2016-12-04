package ru.sbrf.socialnetwork.commons.model.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 27/11/2016.
 */
public class UserFriends {
    /**
     * user account id
     */
    private final long accountId;

    /**
     * ids of user friendsIds
     */
    private final List<Long> friendsIds = new ArrayList<>();

    public UserFriends(long accountId, List<Long> friendsIds) {
        this.accountId = accountId;
        this.friendsIds.addAll(friendsIds);
    }

    public long getAccountId() {
        return accountId;
    }

    public List<Long> getFriendsIds() {
        return Collections.unmodifiableList(friendsIds);
    }
}
