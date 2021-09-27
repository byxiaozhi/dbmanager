package com.zzf.dbmanager;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Objects;

public class JavaFX extends Application {
    static JavaFX instance;
    String beansConfigLocation = "/com/zzf/dbmanager/beans.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(beansConfigLocation);

    public void start(Stage stage) throws IOException {
        instance = this;
        stage.setTitle("数据库管理器");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        openWindow("main", stage);
    }

    public static void showDocument(String s) {
        instance.getHostServices().showDocument(s);
    }

    public static ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }

    public static Scene loadFXML(String fxml) throws IOException {
        var fxmlLoader = new FXMLLoader(JavaFX.class.getResource(fxml));
        fxmlLoader.setControllerFactory(JavaFX.getApplicationContext()::getBean);
        return fxmlLoader.load();
    }

    public static void openWindow(String fxml, Stage stage) throws IOException {
        stage.setScene(loadFXML(String.format("view/%s.fxml", fxml)));
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
}