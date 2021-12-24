package com.jahon.auth;

import com.jahon.auth.model.Token;

import java.util.HashMap;
import java.util.Map;

public class UserTokensStorage {
    private static UserTokensStorage INSTANCE;

    private Map<String, Token> userToken = new HashMap<>();

    private UserTokensStorage() {
    }


    public void put(String login, Token token) {
        userToken.put(login, token);
    }

    public void refreshToken(String user, Token token) {
        if (userToken.replace(user, token) == null) {
            throw new SessionException("No token find to refresh");
        }
    }

    public Token getUserToken(String login) {
        Token token = userToken.get(login);
        if (token == null) {
            throw new SessionException("Token for user not found");
        } else {
            return token;
        }
    }

    public static UserTokensStorage getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (UserTokensStorage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserTokensStorage();
                }
            }
        }

        return INSTANCE;
    }

}
