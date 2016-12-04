package ru.sbrf.socialnetwork.commons.model.account;

import java.time.LocalDateTime;

/**
 * Created by Ivan on 27/11/2016.
 */
public class AccessToken {
    private final long accountId;
    private final String accessToken;
    private final LocalDateTime expirationDate;

    public AccessToken(long accountId,
                       String accessToken,
                       LocalDateTime expirationDate) {
        this.accountId = accountId;
        this.accessToken = accessToken;
        this.expirationDate = expirationDate;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
