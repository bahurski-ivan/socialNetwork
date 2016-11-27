package ru.sbrf.socialnetwork.objects.requests;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;

/**
 * Created by Ivan on 27/11/2016.
 */
public interface Request {
    void handle() throws CannotHandleRequestException;
}
