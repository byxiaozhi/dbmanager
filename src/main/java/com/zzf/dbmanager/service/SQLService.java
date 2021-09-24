package com.zzf.dbmanager.service;

import com.zzf.dbmanager.model.ConnectionModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SQLService {

    Connection connection;
    ConnectionModel connectionModel;

    public SQLService(ConnectionModel connectionModel) {
        this.connectionModel = connectionModel;
    }

    public void disconnect() throws SQLException {
        if (connection != null)
            connection.close();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(connectionModel.getURL(), connectionModel.getUsername(), connectionModel.getPassword());
    }

    public List<Map<String,Object>> executeQuery(String sql) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();

        return null;
    }
}
