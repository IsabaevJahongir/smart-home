package com.jahon.application;

import com.jahon.application.model.Session;

public class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;

    private Session currentSession;

    private ApplicationGlobalState() {
    }

    public static ApplicationGlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public void setCurrentSession(Session session) {
        this.currentSession = session;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}


