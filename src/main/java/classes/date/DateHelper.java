package classes.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    final static Logger logger = LoggerFactory.getLogger(DateHelper.class);

    public static String prepareDateToday() {
        logger.info("Preparing Today date");
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formatDateTime = now.format(formatter);

        return formatDateTime + "T00:00:00.000-0100:" + formatDateTime + "T23:59:59.999-0100";

    }


    public static String transformDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        String dateFirst = date.substring(0, 28);
        String dateSecond = date.substring(29);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse(dateFirst, dateTimeFormatter);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse(dateSecond, dateTimeFormatter);

        long time1 = Timestamp.from(zonedDateTime1.toInstant()).getTime();
        long time2 = Timestamp.from(zonedDateTime2.toInstant()).getTime();

        long randomTimestamp = time1 + (long) (Math.random() * (time2 - time1));

        Instant instant = Instant.ofEpochMilli(randomTimestamp);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zonedDateTime1.getZone());
        return dateTimeFormatter.format(zonedDateTime);
    }
}
