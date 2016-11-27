package ru.sbrf.socialnetwork.objects.requests.user;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.model.user.User;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class CreateUser implements Request {
    private final User user;
    private final String accessToken;

    public CreateUser(User user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public String getAccessToken() {
        return accessToken;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
