package ru.sbrf.socialnetwork.objects.model.photo;

import java.net.URL;
import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Photo {
    private final long photoId;
    private final LocalDate addictionDate;
    private final URL photoUrl;
    private String photoDescription;


    public Photo(long photoId,
                 LocalDate addictionDate,
                 String photoDescription,
                 URL photoUrl) {
        this.photoId = photoId;
        this.photoDescription = photoDescription;
        this.addictionDate = addictionDate;
        this.photoUrl = photoUrl;
    }

    public long getPhotoId() {
        return photoId;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public LocalDate getAddictionDate() {
        return addictionDate;
    }

    public URL getPhotoUrl() {
        return photoUrl;
    }
}
