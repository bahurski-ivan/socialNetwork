package ru.sbrf.socialnetwork.objects.model.account;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class AccessToken {
    private final long accountId;
    private final String token;
    private final LocalDate expirationDate;

    public AccessToken(long accountId, String token, LocalDate expirationDate) {
        this.accountId = accountId;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getToken() {
        return token;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
