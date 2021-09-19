package com.zzf.dbmanager.Controller;

import com.zzf.dbmanager.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AboutController {

    @FXML
    protected void handleConfirm(Event event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    protected void openGitHubLink() {
        Application.getInstance().getHostServices().showDocument("https://github.com/byxiaozhi/dbmanager");
    }
}
