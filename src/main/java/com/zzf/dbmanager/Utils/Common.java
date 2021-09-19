package com.zzf.dbmanager.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class Common {

    public static void openModelWindow(Window owner, URL url, String title, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
