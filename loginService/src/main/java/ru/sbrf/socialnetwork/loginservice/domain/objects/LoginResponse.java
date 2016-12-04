package ru.sbrf.socialnetwork.loginservice.domain.objects;

import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.loginservice.domain.DateTimeToStringConverter;

/**
 * Created by Ivan on 04/12/2016.
 */
public class LoginResponse {
    private final String accessToken;
    private final String expirationDate;

    private LoginResponse(String accessToken, String expirationDate) {
        this.accessToken = accessToken;
        this.expirationDate = expirationDate;
    }

    public static LoginResponse ofToken(AccessToken token, DateTimeToStringConverter converter) {
        return new LoginResponse(token.getAccessToken(),
                converter.toString(token.getExpirationDate()));
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
