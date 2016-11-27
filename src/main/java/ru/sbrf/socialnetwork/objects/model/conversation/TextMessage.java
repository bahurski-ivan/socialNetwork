package ru.sbrf.socialnetwork.objects.model.conversation;

import java.time.LocalDate;

/**
 * Created by Ivan on 27/11/2016.
 */
public class TextMessage {
    private final long conversationId, senderId;
    private final String text;
    private final LocalDate dateTimeSent;


    public TextMessage(long conversationId, long senderId, String text, LocalDate dateTimeSent) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.text = text;
        this.dateTimeSent = dateTimeSent;
    }


    public String getText() {
        return text;
    }

    public long getConversationId() {
        return conversationId;
    }

    public long getSenderId() {
        return senderId;
    }

    public LocalDate getDateTimeSent() {
        return dateTimeSent;
    }
}
