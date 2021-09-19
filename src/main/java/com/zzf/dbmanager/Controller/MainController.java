package com.zzf.dbmanager.Controller;

import com.zzf.dbmanager.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;

import java.io.IOException;

import static com.zzf.dbmanager.Utils.Common.openModelWindow;

public class MainController {

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