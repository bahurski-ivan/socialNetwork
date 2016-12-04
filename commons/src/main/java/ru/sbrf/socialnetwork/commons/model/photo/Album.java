package ru.sbrf.socialnetwork.commons.model.photo;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Album {
    private final long albumId;

    /**
     * id of user who made this album
     */
    private final long creatorId;
    private final String albumName;
    private final LocalDate creationDate;

    public Album(long albumId,
                 long creatorId,
                 String albumName,
                 LocalDate creationDate) {
        this.albumId = albumId;
        this.creatorId = creatorId;
        this.albumName = albumName;
        this.creationDate = creationDate;
    }

    public long getAlbumId() {
        return albumId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
