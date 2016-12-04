package ru.sbrf.socialnetwork.commons.model.conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 01/12/2016.
 */
public class ChatRoom {
    /**
     * conversation id
     */
    private final long roomId;

    /**
     * name of conversation
     */
    private final String roomName;

    /**
     * list of users that is on this conversation
     */
    private final List<Long> participantsIds;

    public ChatRoom(long roomId, String roomName, List<Long> participantsIds) {
        this.roomId = roomId;
        this.roomName = roomName;

        List<Long> p = new ArrayList<>();
        p.addAll(participantsIds);
        this.participantsIds = Collections.unmodifiableList(p);
    }

    public long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<Long> getParticipantsIds() {
        return participantsIds;
    }
}
