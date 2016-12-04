package ru.sbrf.socialnetwork.loginservice.domain.objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Ivan on 01/12/2016.
 */
public class CheckToken {
    @NotNull
    @Size(min = 1, max = 128)
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
