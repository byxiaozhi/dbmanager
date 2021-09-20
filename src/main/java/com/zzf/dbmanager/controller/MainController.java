package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.JavaFX;
import com.zzf.dbmanager.service.ConnectionService;
import com.zzf.dbmanager.utils.EventEmitter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.util.function.Function;

import static com.zzf.dbmanager.utils.Common.openModelWindow;
import static java.util.stream.Collectors.toMap;

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
        var oldRootItemChildrenMap = rootItemChildren.stream().collect(toMap(TreeItem::getValue, Function.identity()));
        rootItemChildren.clear();
        connectionList.forEach(s ->
                rootItemChildren.add(oldRootItemChildrenMap.containsKey(s.getName())
                        ? oldRootItemChildrenMap.get(s.getName())
                        : new TreeItem<>(s.getName()))
        );
    }

    private void connect(String connectionName) {

    }

    @FXML
    protected void openAboutWindow(Event event) throws IOException {
        openModelWindow(
                ((Node) event.getSource()).getScene().getWindow(),
                JavaFX.class.getResource("about.fxml"),
                "关于",
                400,
                200
        );
    }

    @FXML
    protected void openNewConnectionWindow(Event event) throws IOException {
        openModelWindow(
                ((Node) event.getSource()).getScene().getWindow(),
                JavaFX.class.getResource("newConnection.fxml"),
                "新建连接",
                340,
                340
        );
    }
}