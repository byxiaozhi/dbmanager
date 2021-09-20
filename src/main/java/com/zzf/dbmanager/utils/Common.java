package com.zzf.dbmanager.utils;

import com.zzf.dbmanager.JavaFX;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Common {

    public static void openModelWindow(Window owner, URL url, String title, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(Objects.requireNonNull(JavaFX.class.getResourceAsStream("image/logo.png"))));
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void closeEventSourceWindow(Event event){
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    public static void setVerification(Control control, boolean success) {
        var styleClass = control.getStyleClass();
        if (success)
            styleClass.remove("input-error");
        else if (!styleClass.contains("input-error"))
            styleClass.add("input-error");
    }
}
