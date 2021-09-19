package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.Application;
import com.zzf.dbmanager.model.ConnectionModel;
import com.zzf.dbmanager.service.ConnectionService;
import com.zzf.dbmanager.utils.EventEmitter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.util.ArrayList;

import static com.zzf.dbmanager.utils.Common.openModelWindow;

public class MainController {

    @FXML
    TreeView<String> connectionsTree;

    ConnectionService connectionService = ConnectionService.getInstance();

    @FXML
    public void initialize() {
        initConnectionsTree();
    }

    private void initConnectionsTree() {
        connectionsTree.setRoot(new TreeItem<>());
        connectionsTree.setShowRoot(false);
        updateConnectionsTree();
        EventEmitter.addListener("connectionsChange", this::updateConnectionsTree);
    }

    private void updateConnectionsTree() {
        var connectionList = connectionService.getConnectionList();
        var rootItem = connectionsTree.getRoot();
        var rootItemChildren = rootItem.getChildren();
        var oldRootItemChildren = new ArrayList<>(rootItemChildren);
        rootItemChildren.clear();
        connectionList.forEach(s -> {
            var connectionItem = oldRootItemChildren.stream().filter(t -> t.getValue().equals(s.getName())).findAny().orElseGet(() ->
                    new TreeItem<>(s.getName())
            );
            rootItemChildren.add(connectionItem);
        });
    }

    private void connect(String connectionName) {

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