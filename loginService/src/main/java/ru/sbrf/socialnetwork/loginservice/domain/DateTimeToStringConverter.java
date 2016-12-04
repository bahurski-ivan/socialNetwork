package ru.sbrf.socialnetwork.loginservice.domain;

import java.text.ParseException;
import java.time.LocalDateTime;

/**
 * Created by Ivan on 04/12/2016.
 */
public interface DateTimeToStringConverter {
    LocalDateTime parse(String date) throws ParseException;

    String toString(LocalDateTime ldt);
}
