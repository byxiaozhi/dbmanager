package com.zzf.dbmanager.Controller;

import com.zzf.dbmanager.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    protected void OpenAboutWindow(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("about.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        Stage stage = new Stage();
        stage.setTitle("关于");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}