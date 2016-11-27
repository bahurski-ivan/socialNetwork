package ru.sbrf.socialnetwork.objects.model.photo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 27/11/2016.
 */
public class PhotoAlbum {
    private long albumId, userId;

    private String albumName;
    private List<Long> photosIds = new ArrayList<>();


    public PhotoAlbum(long albumId, long userId) {
        this.albumId = albumId;
        this.userId = userId;
    }

    public void addPhotoById(long photo) {
        photosIds.add(photo);
    }

    public void removePhotoById(long photo) {
        photosIds.remove(photo);
    }

    public long getUserId() {
        return userId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Long> getPhotosIds() {
        return Collections.unmodifiableList(photosIds);
    }
}
