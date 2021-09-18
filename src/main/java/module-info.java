module com.zzf.dbmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zzf.dbmanager to javafx.fxml;
    exports com.zzf.dbmanager;
}