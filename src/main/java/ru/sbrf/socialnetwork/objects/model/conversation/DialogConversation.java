package ru.sbrf.socialnetwork.objects.model.conversation;

/**
 * Created by Ivan on 27/11/2016.
 */
public class DialogConversation extends AbstractConversation {
    private final long firstUserId, secondUserId;

    public DialogConversation(long firstUserId, long secondUserId, Long conversationId) {
        super(true, conversationId);
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
    }


    public long getFirstUserId() {
        return firstUserId;
    }

    public long getSecondUserId() {
        return secondUserId;
    }
}
