package ru.sbrf.socialnetwork.objects.requests.conversations.setters;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class SendTextMessage implements Request {
    private final long conversationId;
    private final String accessToken;
    private final String text;

    public SendTextMessage(long conversationId, String accessToken, String text) {
        this.conversationId = conversationId;
        this.accessToken = accessToken;
        this.text = text;
    }

    public long getConversationId() {
        return conversationId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getText() {
        return text;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
