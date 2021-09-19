package com.zzf.dbmanager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Application mInstance;

    public void start(Stage stage) throws IOException {
        mInstance = this;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setTitle("数据库管理器");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        stage.setScene(scene);
        stage.show();
    }

    public static Application getInstance() {
        return mInstance;
    }

    public static void main(String[] args) {
        launch();
    }
}