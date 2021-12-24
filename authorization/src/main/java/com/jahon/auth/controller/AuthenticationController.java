package com.jahon.auth.controller;


import com.jahon.auth.SessionException;
import com.jahon.auth.UserTokensStorage;
import com.jahon.auth.model.Login;
import com.jahon.auth.model.User;
import com.jahon.auth.repository.UserRepository;
import com.jahon.auth.jwt.JWTUtil;
import com.jahon.auth.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.SQLException;


@RestController
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User newUser) {
        ResponseEntity responseEntity;
        try {
            userRepo.insertUser(newUser);
            responseEntity = new ResponseEntity(String.format("Welcome %s!", newUser.getLogin()), HttpStatus.OK);
        } catch (SQLException throwables) {
            if (throwables.getErrorCode() == 0) {
                log.info("Login for user - {} already in use", newUser.getLogin());
                responseEntity = new ResponseEntity<>("Login already in use", HttpStatus.CONFLICT);
            } else {
                log.error("Database error: ", throwables);
                responseEntity = new ResponseEntity<>("Try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Login login) {
        ResponseEntity responseEntity;
        try {
            boolean isLogged = userRepo.isLogged(login);
            if (isLogged) {
                String role = userRepo.getUserRole(login.getLogin());
                Token token = jwtUtil.generateTokens(login.getLogin(), role);

                responseEntity = new ResponseEntity<>(token, HttpStatus.OK);

                UserTokensStorage.getINSTANCE().put(login.getLogin(), token);

            } else {
                responseEntity = new ResponseEntity<>("Incorrect credential", HttpStatus.BAD_REQUEST);
            }
        } catch (SQLException throwables) {
            log.error("Database error: ", throwables);
            responseEntity = new ResponseEntity<>("Try later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/refresh")
    public ResponseEntity<Token> refresh(@RequestHeader("refresh-token") String refreshToken) {
        log.info("Start update token. Refresh token is: {}", refreshToken);
        ResponseEntity responseEntity;
        try {

            Claims claims = jwtUtil.verify(refreshToken);

            claims.forEach((k, v) -> log.info("{}:   {}", k, v));

            String login = claims.get("login").toString();
            String role = claims.get("role").toString();

            Token token = UserTokensStorage.getINSTANCE().getUserToken(login);

            if (token.getRefresh().equals(refreshToken)) {
                Token newToken = jwtUtil.generateTokens(login, role);
                UserTokensStorage.getINSTANCE().refreshToken(login, newToken);
                responseEntity = new ResponseEntity<>(newToken, HttpStatus.OK);
            } else {
                log.info("Refresh token doesn't match. \nFrom user: {} \nFrom session: {}", refreshToken, token.getRefresh());
                responseEntity = new ResponseEntity<>("Login again", HttpStatus.UNAUTHORIZED);
            }


        } catch (SessionException ex) {
            log.error("Exception: ", ex);
            responseEntity = new ResponseEntity<>("Login again", HttpStatus.UNAUTHORIZED);
        } catch (ExpiredJwtException ex) {
            log.error("Token expired: ", ex);
            return new ResponseEntity("Token expired", HttpStatus.UNAUTHORIZED);
        } catch (SignatureException ex) {
            log.error("Wrong signature: ", ex);
            return new ResponseEntity("Wrong signature. Re-login, please!!!", HttpStatus.UNAUTHORIZED);
        }

        return responseEntity;

    }

}