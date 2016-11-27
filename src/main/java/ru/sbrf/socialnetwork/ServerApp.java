package ru.sbrf.socialnetwork;

import ru.sbrf.socialnetwork.exceptions.CannotHandleRequestException;
import ru.sbrf.socialnetwork.objects.requests.Request;

/**
 * Created by Ivan on 27/11/2016.
 */
public class ServerApp {
    public static void main(String[] args) {
        // wait for any request
        RequestReader reader = null;   // todo
        boolean running = true;

        while (running) {
            Request request = reader.next();
            if (request != null) {
                try {
                    request.handle();
                } catch (CannotHandleRequestException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
