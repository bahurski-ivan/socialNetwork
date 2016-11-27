package ru.sbrf.socialnetwork.objects.requests.conversations.control;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class SetConversationTitle implements Request {
    private final long conversationId;
    private final String newTitle;
    private final String accessToken;

    public SetConversationTitle(long conversationId, String newTitle, String accessToken) {
        this.conversationId = conversationId;
        this.newTitle = newTitle;
        this.accessToken = accessToken;
    }

    public long getConversationId() {
        return conversationId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public String getAccessToken() {
        return accessToken;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
