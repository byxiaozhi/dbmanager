package com.zzf.dbmanager.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class newConnectionController {

    @FXML
    protected void handleConfirm (Event event) {

    }

    @FXML
    protected void handleCancel (Event event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    protected void handleTestConnection (Event event) {

    }
}
