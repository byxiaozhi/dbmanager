package com.zzf.dbmanager.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    public Map<String, List<Runnable>> listenersMap = new HashMap<>();

    public void addListener(String type, Runnable listener) {
        if (!listenersMap.containsKey(type))
            listenersMap.put(type, new ArrayList<>());
        listenersMap.get(type).add(listener);
    }

    public void removeListener(String type) {
        listenersMap.remove(type);
    }

    public void removeListener(String type, Runnable listener) {
        if (listenersMap.containsKey(type))
            listenersMap.get(type).remove(listener);
    }

    public void emit(String type) {
        if (listenersMap.containsKey(type))
            listenersMap.get(type).forEach(Runnable::run);
    }

}
