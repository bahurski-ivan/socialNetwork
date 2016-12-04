package ru.sbrf.socialnetwork.commons.responses;

/**
 * Created by Ivan on 01/12/2016.
 */
public class Ok<T> {
    private final T object;

    public Ok(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
