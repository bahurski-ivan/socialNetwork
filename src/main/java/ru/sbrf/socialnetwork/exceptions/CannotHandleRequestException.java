package ru.sbrf.socialnetwork.exceptions;

/**
 * Created by Ivan on 27/11/2016.
 */
public class CannotHandleRequestException extends Exception {
    public CannotHandleRequestException() {
        super();
    }

    public CannotHandleRequestException(String message) {
        super(message);
    }

    public CannotHandleRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotHandleRequestException(Throwable cause) {
        super(cause);
    }
}
