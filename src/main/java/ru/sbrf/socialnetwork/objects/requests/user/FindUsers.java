package ru.sbrf.socialnetwork.objects.requests.user;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Pagination;
import ru.sbrf.socialnetwork.objects.requests.Request;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class FindUsers implements Request {
    private final Pagination pagination;
    private final String accessToken;
    private final String firstName, middleName, lastName;
    private final LocalDate birthDate;

    public FindUsers(Pagination pagination,
                     String accessToken,
                     String firstName,
                     String middleName,
                     String lastName,
                     LocalDate birthDate) {
        this.pagination = pagination;
        this.accessToken = accessToken;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
