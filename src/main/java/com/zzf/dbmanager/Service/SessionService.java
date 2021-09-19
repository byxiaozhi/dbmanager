package com.zzf.dbmanager.Service;

import com.zzf.dbmanager.Application;
import com.zzf.dbmanager.Model.SessionModel;

import java.util.ArrayList;
import java.util.List;

public class SessionService {

    private static final SessionService mInstance = new SessionService();
    List<SessionModel> sessionList = new ArrayList<>();

    public static SessionService getInstance() {
        return mInstance;
    }

    public void addSession(SessionModel session) {
        sessionList.add(session);
    }

    public List<SessionModel> getSessionList() {
        return sessionList;
    }

    public boolean existSession(String sessionName) {
        return sessionList.stream().anyMatch(s -> s.getName().equals(sessionName));
    }
}
