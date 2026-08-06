package util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * This is for execution time
 * */
public class TimeUtil {

    // Formatter for date/time
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** Returns current timestamp formatted as yyyy-MM-dd HH:mm:ss */
    public static String now() {
        return Instant.now()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(formatter);
    }

    /** Returns current time in milliseconds */
    public static long nowMillis() {
        return System.currentTimeMillis();
    }

    /** Format any milliseconds timestamp into yyyy-MM-dd HH:mm:ss */
    public static String formatMillis(long millis) {
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(formatter);
    }

    /** Format a duration in milliseconds into HH:mm:ss */
    public static String formatDuration(long startMillis, long endMillis) {
        long duration = endMillis - startMillis;
        long seconds = duration / 1000;

        return String.format("%02d:%02d:%02d",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60);
    }
}