package ru.sbrf.socialnetwork.objects.responses;

/**
 * Created by Ivan on 27/11/2016.
 */
public class ErrorResponse {
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
