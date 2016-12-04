package ru.sbrf.socialnetwork.commons.model.photo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 01/12/2016.
 */
public class AlbumContent {
    private final long albumId;
    private final List<Long> photosIds = new ArrayList<>();

    public AlbumContent(long albumId, List<Long> photosIds) {
        this.albumId = albumId;
        this.photosIds.addAll(photosIds);
    }

    public long getAlbumId() {
        return albumId;
    }

    public List<Long> getPhotosIds() {
        return Collections.unmodifiableList(photosIds);
    }
}
