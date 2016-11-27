package ru.sbrf.socialnetwork.objects.requests.conversations.control;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class RemoveUserFromConversation implements Request {
    private final String accessToken;
    private final long userId, conversationId;

    public RemoveUserFromConversation(String accessToken, long userId, long conversationId) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.conversationId = conversationId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getUserId() {
        return userId;
    }

    public long getConversationId() {
        return conversationId;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
