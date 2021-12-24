package com.jahon.auth.jwt;

import com.jahon.auth.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTUtil {
    @Value("${secretKey}")
    private String secretKey;
    @Value("${sessionTime}")
    private long sessionTime;
    @Value("${refreshTokenTime}")
    private long refreshTokenTime;
    @Value("${issuer}")
    private String issuer;

    public Token generateTokens(String login, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("login", login);
        claims.put("role", role);
        String access = createToken(claims, sessionTime);
        String refresh = createToken(claims, refreshTokenTime);

        Token token = new Token(access, refresh);

        return token;
    }

    private String createToken(Map<String, Object> claims, long expire) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(claims.get("login").toString())
                .setIssuer(issuer)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expireTimeFromNow(expire))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();

    }

    private Date expireTimeFromNow(long expire) {
        return new Date(System.currentTimeMillis() + expire);
    }


    public Claims verify(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }


}