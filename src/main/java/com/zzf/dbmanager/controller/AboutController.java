package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.JavaFX;
import javafx.event.Event;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

import static com.zzf.dbmanager.utils.Common.closeEventSourceWindow;

@Controller
public class AboutController {

    @FXML
    protected void handleConfirm(Event event) {
        closeEventSourceWindow(event);
    }

    @FXML
    protected void openGitHubLink() {
        JavaFX.showDocument("https://github.com/byxiaozhi/dbmanager");
    }
}
