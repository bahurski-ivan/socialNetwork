package ru.sbrf.socialnetwork.objects.requests.auth;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Login implements Request {
    private final String userName;
    private final String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
