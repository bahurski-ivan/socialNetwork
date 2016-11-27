package ru.sbrf.socialnetwork.objects.requests.conversations.getters;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Pagination;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class GetTextMessages implements Request {
    private final long conversationId;
    private final String accessToken;
    private final Pagination pagination;

    public GetTextMessages(long conversationId, String accessToken, Pagination pagination) {
        this.conversationId = conversationId;
        this.accessToken = accessToken;
        this.pagination = pagination;
    }

    public long getConversationId() {
        return conversationId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Pagination getPagination() {
        return pagination;
    }


    @Override
    public void handle() throws CannotHandleRequestException {
        // TODO
    }
}
