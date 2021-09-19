package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.Application;
import com.zzf.dbmanager.service.ConnectionService;
import com.zzf.dbmanager.utils.EventEmitter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;

import static com.zzf.dbmanager.utils.Common.openModelWindow;

public class MainController {

    @FXML
    TreeView<String> connectionsTree;

    ConnectionService connectionService = ConnectionService.getInstance();

    @FXML
    public void initialize() {
        updateConnectionsTree();
        EventEmitter.addListener("connectionsChange", this::updateConnectionsTree);
    }

    private void updateConnectionsTree() {
        var connectionList = connectionService.getConnectionList();
        var rootItem = new TreeItem<String>("所有连接");
        var rootItemChildren = rootItem.getChildren();

        connectionList.forEach(s -> {
            var connectionItem = new TreeItem<>(s.getName());
            rootItemChildren.add(connectionItem);
        });

        connectionsTree.setRoot(rootItem);
    }

    @FXML
    protected void openAboutWindow(Event event) throws IOException {
        openModelWindow(
                ((Node) event.getSource()).getScene().getWindow(),
                Application.class.getResource("about.fxml"),
                "关于",
                400,
                200
        );
    }

    @FXML
    protected void openNewConnectionWindow(Event event) throws IOException {
        openModelWindow(
                ((Node) event.getSource()).getScene().getWindow(),
                Application.class.getResource("newConnection.fxml"),
                "新建连接",
                340,
                340
        );
    }
}