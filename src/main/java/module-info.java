module com.zzf.dbmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zzf.dbmanager to javafx.fxml;
    exports com.zzf.dbmanager;
    exports com.zzf.dbmanager.controller;
    opens com.zzf.dbmanager.controller to javafx.fxml;
}