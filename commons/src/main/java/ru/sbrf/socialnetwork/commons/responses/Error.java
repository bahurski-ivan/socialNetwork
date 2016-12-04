package ru.sbrf.socialnetwork.commons.responses;

/**
 * Created by Ivan on 01/12/2016.
 */
public class Error {
    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
