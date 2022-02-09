package com.jahon.server.controller;

import com.jahon.server.JwtDecoder;
import com.jahon.server.model.Payload;
import com.jahon.server.smarthome.item.SmartHome;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RestController
public class UserHomeInitController {
    private static final Logger log = LoggerFactory.getLogger(UserHomeInitController.class);

    @Autowired
    private JwtDecoder decoder;


    @PostMapping("/userhome")
    public ResponseEntity<String> registerHome(@RequestHeader Map<String, String> headers, @RequestBody SmartHome smarthome) {
        log.debug("Start init home");

        headers.forEach((k, v) -> log.info("'{}' - '{}'", k, v));

        log.info(smarthome.toString());

        try {
            String token = headers.get("authorization");

            log.info("Token: {}", token);

            Claims claims = decoder.verify(token);

            log.info("Payload: {}", claims);

            String role = claims.get("role").toString();

            if (!"admin".equals(role)) {
                log.info("Request not permitted for user with role: {}", role);
                return new ResponseEntity<>("User is not admin", HttpStatus.FORBIDDEN);
            }

        } catch (ExpiredJwtException ex) {
            log.error("Token expired: ", ex);
            return new ResponseEntity<>("Token expired", HttpStatus.FORBIDDEN);
        } catch (SignatureException ex) {
            log.error("Wrong signature ", ex);
            return new ResponseEntity<>("Wrong signature. Re-login, please!!!", HttpStatus.FORBIDDEN);
        }

        log.debug("End init home");
        return new ResponseEntity<>("Smarthome register successfully ", HttpStatus.OK);
    }

}
