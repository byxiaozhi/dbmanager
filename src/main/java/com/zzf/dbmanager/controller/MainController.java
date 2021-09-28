package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.service.ConnectionService;
import com.zzf.dbmanager.service.EventService;
import com.zzf.dbmanager.service.WindowService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Controller
public class MainController {

    @FXML
    TreeView<String> connectionsTree;

    EventService eventService;
    WindowService windowService;
    ConnectionService connectionService;

    public MainController(EventService eventService, WindowService windowService, ConnectionService connectionService) {
        this.eventService = eventService;
        this.windowService = windowService;
        this.connectionService = connectionService;
    }

    @FXML
    public void initialize() {
        initConnectionsTree();
    }

    private void initConnectionsTree() {
        connectionsTree.setRoot(new TreeItem<>());
        connectionsTree.setShowRoot(false);
        updateConnectionsTree();
        eventService.addListener("connectionsChange", this::updateConnectionsTree);
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
        windowService.openAboutWindow(((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void openNewConnectionWindow(Event event) throws IOException {
        windowService.openNewConnectionWindow(((Node) event.getSource()).getScene().getWindow());
    }
}