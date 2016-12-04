package ru.sbrf.socialnetwork.loginservice.domain.impl.dtconv;

import ru.sbrf.socialnetwork.loginservice.domain.DateTimeToStringConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Ivan on 04/12/2016.
 */
public class Iso8601DateTimeConverter implements DateTimeToStringConverter {
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    public Iso8601DateTimeConverter() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        df.setTimeZone(tz);
    }

    @Override
    public LocalDateTime parse(String date) throws ParseException {
        Date asDate = df.parse(date);
        return LocalDateTime.ofInstant(asDate.toInstant(), ZoneId.systemDefault());
    }

    @Override
    public String toString(LocalDateTime ldt) {
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        Date asDate = Date.from(zdt.toInstant());
        return df.format(asDate);
    }
}
