module com.zzf.dbmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zzf.dbmanager to javafx.fxml;
    exports com.zzf.dbmanager;
    exports com.zzf.dbmanager.Controller;
    opens com.zzf.dbmanager.Controller to javafx.fxml;
}