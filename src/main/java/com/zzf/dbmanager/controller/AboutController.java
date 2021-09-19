package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.Application;
import javafx.event.Event;
import javafx.fxml.FXML;

import static com.zzf.dbmanager.utils.Common.closeEventSourceWindow;

public class AboutController {

    @FXML
    protected void handleConfirm(Event event) {
        closeEventSourceWindow(event);
    }

    @FXML
    protected void openGitHubLink() {
        Application.getInstance().getHostServices().showDocument("https://github.com/byxiaozhi/dbmanager");
    }
}