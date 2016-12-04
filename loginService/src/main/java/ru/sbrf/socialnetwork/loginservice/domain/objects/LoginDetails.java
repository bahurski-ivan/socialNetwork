package ru.sbrf.socialnetwork.loginservice.domain.objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Ivan on 27/11/2016.
 */
public class LoginDetails {
    @NotNull
    @Size(min = 1, max = 32)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String userName;

    @NotNull
    @Size(min = 4, max = 256)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
