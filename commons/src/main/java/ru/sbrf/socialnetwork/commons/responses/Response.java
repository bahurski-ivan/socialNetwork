package ru.sbrf.socialnetwork.commons.responses;

/**
 * Created by Ivan on 04/12/2016.
 */
public class Response<T> {
    private final String status;
    private final T object;


    public Response(String status, T object) {
        this.status = status;
        this.object = object;
    }

    public static <T> Response<T> ofOk(T object) {
        return new Response<T>("ok", object);
    }

    public static <T> Response<T> ofError(T object) {
        return new Response<T>("error", object);
    }

    public String getStatus() {
        return status;
    }

    public T getObject() {
        return object;
    }
}
