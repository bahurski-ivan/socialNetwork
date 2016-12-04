package ru.sbrf.socialnetwork.commons.model.account;

import java.time.LocalDateTime;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Account {
    private final long id;
    private final String userName;
    private final String passwordMd5;
    private final LocalDateTime creationDate;

    public Account(String userName,
                   String passwordMd5) {
        this.id = -1;
        this.userName = userName;
        this.passwordMd5 = passwordMd5;
        this.creationDate = null;
    }

    public Account(long id,
                   String userName,
                   String passwordMd5,
                   LocalDateTime creationDate) {
        this.id = id;
        this.userName = userName;
        this.passwordMd5 = passwordMd5;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id == -1 ? null : id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
