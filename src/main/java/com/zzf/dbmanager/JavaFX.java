package com.zzf.dbmanager;

import com.zzf.dbmanager.utils.Common;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class JavaFX extends Application {
    static JavaFX instance;
    String beansConfigLocation = "/com/zzf/dbmanager/beans.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(beansConfigLocation);

    public void start(Stage stage) throws IOException {
        instance = this;
        stage.setTitle("数据库管理器");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        Common.openWindow("view/main.fxml", stage);
    }

    public static void showDocument(String s) {
        instance.getHostServices().showDocument(s);
    }

    public static ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }
}