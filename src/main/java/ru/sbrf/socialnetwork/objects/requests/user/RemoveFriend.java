package ru.sbrf.socialnetwork.objects.requests.user;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class RemoveFriend implements Request {
    private final String accessToken;
    private final long userId;

    public RemoveFriend(String accessToken, long userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getUserId() {
        return userId;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
