package alumnimanagement.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class Helper {

    public static Long getLoggedUserId()
    {
        return 1L;
    }

    public static LocalDateTime getCurrentDate()
    {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }

}
