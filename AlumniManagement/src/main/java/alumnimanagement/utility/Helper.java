package alumnimanagement.utility;

import alumnimanagement.jwt.JWTUtility;
import io.jsonwebtoken.Claims;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@Component
@NoArgsConstructor
public class Helper {
    @Autowired
    private  JWTUtility jwtUtility;


    private Long getClaims(String token)
    {
        Claims claims = jwtUtility.getAllClaimsFromToken(token);
        String claimId =claims.get("id").toString();
        long id= Long.parseLong(claimId);
        return id;
    }
    public Long getLoggedUserId()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var token = authentication.getCredentials();
        return getClaims(token.toString());
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
