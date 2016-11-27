package ru.sbrf.socialnetwork.objects.requests.albums;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class GetAlbum implements Request {
    private final long albumId;
    private final String accessToken;

    public GetAlbum(long albumId, String accessToken) {
        this.albumId = albumId;
        this.accessToken = accessToken;
    }

    public long getAlbumId() {
        return albumId;
    }

    public String getAccessToken() {
        return accessToken;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
