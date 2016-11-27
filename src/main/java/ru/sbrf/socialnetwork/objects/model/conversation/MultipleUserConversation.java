package ru.sbrf.socialnetwork.objects.model.conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ivan on 27/11/2016.
 */
public class MultipleUserConversation extends AbstractConversation {
    private final String title;
    private final List<Long> participants;

    private MultipleUserConversation(String title, List<Long> participants, Long conversationId) {
        super(false, conversationId);
        this.title = title;
        this.participants = Collections.unmodifiableList(participants);
    }


    public static Builder from(MultipleUserConversation prototype) {
        Objects.requireNonNull(prototype);
        return new Builder(prototype);
    }

    public static Builder custom() {
        return new Builder();
    }


    public String getTitle() {
        return title;
    }

    public List<Long> getParticipantsIds() {
        return participants;
    }


    public static class Builder {
        private String title = "";
        private Long conversationId = null;
        private List<Long> participants = new ArrayList<>();

        private Builder(MultipleUserConversation prototype) {
            conversationId = prototype.getConversationId();
            title = prototype.title == null ? "" : prototype.title;
            participants.addAll(prototype.participants);
        }

        private Builder() {
        }

        public void setConversationId(long conversationId) {
            this.conversationId = conversationId;
        }

        public void addParticipantById(long id) {
            participants.add(id);
        }

        public void removeParticipantById(long id) {
            participants.remove(id);
        }

        public void setTitle(String title) {
            this.title = title == null ? "" : title;
        }

        public MultipleUserConversation build() {
            return new MultipleUserConversation(title, participants, conversationId);
        }
    }
}
