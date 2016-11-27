package ru.sbrf.socialnetwork.objects.model.user;

import ru.sbrf.socialnetwork.objects.model.ObjectBuilder;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class User {
    private long id;
    private String firstName, secondName, lastName;
    private LocalDate birthDate;
    private long userPhotoId;


    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getUserPhotoId() {
        return userPhotoId;
    }

    public void setUserPhotoId(long userPhotoId) {
        this.userPhotoId = userPhotoId;
    }

    public static class Builder extends ObjectBuilder<User> {
        private Builder() {
            super(new User());
        }

        private Builder(long id) {
            super(new User(id));
        }

        public void setFirstName(String firstName) {
            result.firstName = firstName;
        }

        public void setSecondName(String secondName) {
            result.secondName = secondName;
        }

        public void setLastName(String lastName) {
            result.lastName = lastName;
        }


    }
}
