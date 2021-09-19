package com.zzf.dbmanager.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

import static com.zzf.dbmanager.Utils.Common.closeEventSourceWindow;
import static com.zzf.dbmanager.Utils.Common.setVerification;

public class newConnectionController {

    @FXML
    TextField connectionName, connectionHost, connectionPort, connectionUsername, connectionPassword, connectionExtraParams;

    ArrayList<BooleanSupplier> checkFunList = new ArrayList<>() {{
        add(() -> validateName());
        add(() -> validateHost());
        add(() -> validatePort());
        add(() -> validateUsername());
    }};

    @FXML
    ChoiceBox<String> connectionType;

    @FXML
    public void initialize() {
        connectionType.getItems().add("MySQL");
        connectionType.setValue(connectionType.getItems().get(0));
        connectionPort.setText("3306");
        connectionHost.setText("localhost");
    }

    private boolean validateName() {
        var success = !connectionName.getText().isBlank();
        setVerification(connectionName, success);
        return success;
    }

    private boolean validateHost() {
        var success = !connectionHost.getText().isBlank();
        setVerification(connectionHost, success);
        return success;
    }

    private boolean validatePort() {
        var text = connectionPort.getText();
        var success = text.matches("[0-9]+") && Integer.parseInt(text) >= 1 && Integer.parseInt(text) <= 65535;
        setVerification(connectionPort, success);
        return success;
    }

    private boolean validateUsername() {
        var success = !connectionUsername.getText().isBlank();
        setVerification(connectionUsername, success);
        return success;
    }

    private boolean validateAll() {
        AtomicBoolean result = new AtomicBoolean(true);
        checkFunList.forEach(f -> {
            if (!f.getAsBoolean())
                result.set(false);
        });
        return result.get();
    }

    @FXML
    protected void handleConfirm(Event event) {
        var success = validateAll();
        if (!success)
            return;
        closeEventSourceWindow(event);
    }

    @FXML
    protected void handleCancel(Event event) {
        closeEventSourceWindow(event);
    }

    @FXML
    protected void handleTestConnection(Event event) {
        var success = validateAll();
    }
}
