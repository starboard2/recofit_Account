package recofit.account.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import recofit.account.domain.entity.Account;

import java.util.Date;

@Slf4j
@Component
public class JwtUtil {
    private static final String BEARER_TYPE = "bearer ";
    private static final String SECRETKEY = "recofit-secretkey";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24;       // 1일(86,400,000)
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;  // 7일(604,800,000)


    public String createAccessToken(Account account) {
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject("recofit")
                .claim("id", account.getUserId())
                .claim("name", account.getUserName())
                .claim("type", account.getUserType())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + ACCESS_TOKEN_EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRETKEY)
                .compact();
    }


    public String createRefreshToken() {
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRETKEY)
                .compact();
    }

}
