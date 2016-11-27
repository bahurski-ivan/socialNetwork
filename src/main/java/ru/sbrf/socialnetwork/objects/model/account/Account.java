package ru.sbrf.socialnetwork.objects.model.account;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Account {
    private final long id;
    private final String userName;
    private final String passwordMd5;
    private final LocalDate creationDate;

    private long userId;


    public Account(long id, String userName, String passwordMd5, LocalDate creationDate) {
        this.id = id;
        this.userName = userName;
        this.passwordMd5 = passwordMd5;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
