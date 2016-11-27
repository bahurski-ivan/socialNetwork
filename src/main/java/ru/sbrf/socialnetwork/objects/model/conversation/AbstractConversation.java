package ru.sbrf.socialnetwork.objects.model.conversation;

/**
 * Created by Ivan on 27/11/2016.
 */
public abstract class AbstractConversation {
    private final boolean isDialog;
    private final Long conversationId;

    AbstractConversation(boolean isDialog, Long conversationId) {
        this.isDialog = isDialog;
        this.conversationId = conversationId;
    }

    public long getConversationId() {
        return conversationId;
    }
}
