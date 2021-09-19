package com.zzf.dbmanager.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventEmitter {

    public static Map<String, List<Runnable>> listenersMap = new HashMap<>();

    public static void addListener(String type, Runnable listener) {
        if (!listenersMap.containsKey(type))
            listenersMap.put(type, new ArrayList<>());
        listenersMap.get(type).add(listener);
    }

    public static void removeListener(String type) {
        listenersMap.remove(type);
    }

    public static void removeListener(String type, Runnable listener) {
        if (listenersMap.containsKey(type))
            listenersMap.get(type).remove(listener);
    }

    public static void emit(String type, Object obj) {
        if (listenersMap.containsKey(type))
            listenersMap.get(type).forEach(Runnable::run);
    }

    public static void emit(String type) {
        emit(type, null);
    }

}
