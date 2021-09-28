package com.zzf.dbmanager.service;

import com.zzf.dbmanager.model.ConnectionModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class ConnectionService{

    EventEmitter eventEmitter;
    Map<String, ConnectionModel> connectionMap = new HashMap<>();

    public ConnectionService(EventEmitter eventEmitter) {
        this.eventEmitter = eventEmitter;
    }

    public void handleConnectionsChange() {
        eventEmitter.emit("connectionsChange", null);
    }

    public void addConnection(ConnectionModel connection) {
        connectionMap.put(connection.getName(), connection);
        handleConnectionsChange();
    }

    public void removeConnection(String connectionName) {
        connectionMap.remove(connectionName);
        handleConnectionsChange();
    }

    public List<ConnectionModel> getConnectionList() {
        return connectionMap.values().stream().sorted(comparing(ConnectionModel::getName)).collect(Collectors.toList());
    }

    public Map<String, ConnectionModel> getConnectionMap() {
        return connectionMap;
    }

    public boolean existConnection(String connectionName) {
        return connectionMap.containsKey(connectionName);
    }
}
