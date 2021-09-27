package com.zzf.dbmanager.utils;

import com.zzf.dbmanager.JavaFX;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class Common {

    public static Scene loadFXML(String fxml) throws IOException {
        var fxmlLoader = new FXMLLoader(JavaFX.class.getResource(fxml));
        fxmlLoader.setControllerFactory(JavaFX.getApplicationContext()::getBean);
        return fxmlLoader.load();
    }

    public static void openWindow(String fxml, Stage stage) throws IOException {
        stage.setScene(loadFXML(fxml));
        stage.getIcons().add(new Image(Objects.requireNonNull(JavaFX.class.getResourceAsStream("image/logo.png"))));
        stage.show();
    }

    public static void openModelWindow(Window owner, String fxml, String title) throws IOException {
        openWindow(fxml, new Stage() {{
            setTitle(title);
            initModality(Modality.WINDOW_MODAL);
            initOwner(owner);
        }});
    }

    public static void closeEventSourceWindow(Event event) {
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
