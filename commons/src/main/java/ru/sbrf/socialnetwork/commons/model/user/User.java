package ru.sbrf.socialnetwork.commons.model.user;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class User {
    /**
     * user account id
     */
    private final long accountId;

    /**
     * main photo id
     */
    private final long userPhotoId;

    /**
     * user birth date
     */
    private final LocalDate birthDate;

    /**
     * user's first middle and last names
     */
    private final String firstName, secondName, lastName;

    public User(long accountId,
                long userPhotoId,
                LocalDate birthDate,
                String firstName,
                String secondName,
                String lastName) {
        this.accountId = accountId;
        this.userPhotoId = userPhotoId;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getUserPhotoId() {
        return userPhotoId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }
}
