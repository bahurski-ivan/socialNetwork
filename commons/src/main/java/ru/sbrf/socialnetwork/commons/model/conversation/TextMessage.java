package ru.sbrf.socialnetwork.commons.model.conversation;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class TextMessage {
    /**
     * id of the conversation (room)
     */
    private final long roomId;

    /**
     * id of user who sent this message to the room
     */
    private final long senderId;

    /**
     * content of text message
     */
    private final String text;
    private final LocalDate dateTimeSent;

    public TextMessage(long roomId,
                       long senderId,
                       String text,
                       LocalDate dateTimeSent) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.text = text;
        this.dateTimeSent = dateTimeSent;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getSenderId() {
        return senderId;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDateTimeSent() {
        return dateTimeSent;
    }
}
