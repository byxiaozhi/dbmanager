package com.zzf.dbmanager.service;

import javafx.fxml.FXML;
import javafx.stage.Window;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.zzf.dbmanager.JavaFX.openModelWindow;

@Service
public class WindowService {

    @FXML
    public void openAboutWindow(Window owner) throws IOException {
        openModelWindow(owner, "about", "关于");
    }

    @FXML
    public void openNewConnectionWindow(Window owner) throws IOException {
        openModelWindow(owner, "newConnection", "新建连接");
    }
}
