package ru.sbrf.socialnetwork.commons.model.photo;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Photo {
    /**
     * photo id
     */
    private final long photoId;

    /**
     * id of user who upload this image
     */
    private final long uploaderId;

    /**
     * image bytes
     */
    private final byte[] photoBytes;

    /**
     * image uploading date
     */
    private final LocalDate uploadDate;

    /**
     * photo description
     */
    private final String photoDescription;

    public Photo(long photoId,
                 long uploaderId,
                 byte[] photoBytes,
                 LocalDate uploadDate,
                 String photoDescription) {
        this.photoId = photoId;
        this.uploaderId = uploaderId;
        this.photoBytes = photoBytes;
        this.uploadDate = uploadDate;
        this.photoDescription = photoDescription;
    }

    public long getPhotoId() {
        return photoId;
    }

    public long getUploaderId() {
        return uploaderId;
    }

    public byte[] getPhotoBytes() {
        return photoBytes;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }
}
