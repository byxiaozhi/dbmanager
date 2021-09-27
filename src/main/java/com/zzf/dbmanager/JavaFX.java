package com.zzf.dbmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JavaFX extends Application {
    private static JavaFX mInstance;

    public void start(Stage stage) throws IOException {
        mInstance = this;
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFX.class.getResource("view/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.getIcons().add(new Image(Objects.requireNonNull(JavaFX.class.getResourceAsStream("image/logo.png"))));
        stage.setTitle("数据库管理器");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        stage.setScene(scene);
        stage.show();
    }

    public static JavaFX getInstance() {
        return mInstance;
    }
}