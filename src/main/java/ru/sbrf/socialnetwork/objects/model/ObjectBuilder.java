package ru.sbrf.socialnetwork.objects.model;

/**
 * Created by Ivan on 27/11/2016.
 */
public class ObjectBuilder<T> {
    protected final T result;

    public ObjectBuilder(T result) {
        this.result = result;
    }

    public T build() {
        return result;
    }
}
