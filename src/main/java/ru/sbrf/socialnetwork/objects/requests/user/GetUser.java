package ru.sbrf.socialnetwork.objects.requests.user;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class GetUser implements Request {
    private final long userId;
    private final String accessToken;

    public GetUser(long userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    public long getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
