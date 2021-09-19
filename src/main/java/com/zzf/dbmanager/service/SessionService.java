package com.zzf.dbmanager.service;

import com.zzf.dbmanager.model.SessionModel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SessionService {

    private static final SessionService mInstance = new SessionService();
    Map<String, SessionModel> sessionMap = new HashMap<>();

    public static SessionService getInstance() {
        return mInstance;
    }

    public void addSession(SessionModel session) {
        sessionMap.put(session.getName(), session);
    }

    public void removeSession(String sessionName) {
        sessionMap.remove(sessionName);
    }

    public List<SessionModel> getSessionList() {
        return sessionMap.values().stream().toList();
    }

    public Map<String, SessionModel> getSessionMap() {
        return sessionMap;
    }

    public boolean existSession(String sessionName) {
        return sessionMap.containsKey(sessionName);
    }
}
