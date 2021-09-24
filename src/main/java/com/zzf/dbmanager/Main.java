package com.zzf.dbmanager;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.setProperty("prism.lcdtext", "false");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Application.launch(JavaFX.class, args);
    }
}