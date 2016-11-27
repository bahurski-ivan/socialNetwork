package ru.sbrf.socialnetwork.objects.requests.conversations.getters;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class GetConversation implements Request {
    private final long conversationId;
    private final String accessToken;

    public GetConversation(long conversationId, String accessToken) {
        this.conversationId = conversationId;
        this.accessToken = accessToken;
    }

    public long getConversationId() {
        return conversationId;
    }

    public String getAccessToken() {
        return accessToken;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
