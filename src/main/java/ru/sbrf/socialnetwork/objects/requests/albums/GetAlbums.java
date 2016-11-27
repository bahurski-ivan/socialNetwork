package ru.sbrf.socialnetwork.objects.requests.albums;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Pagination;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class GetAlbums implements Request {
    private final long userId;
    private final String accessToken;
    private final Pagination pagination;

    public GetAlbums(long userId, String accessToken, Pagination pagination) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.pagination = pagination;
    }

    public long getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Pagination getPagination() {
        return pagination;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
