package com.zzf.dbmanager.controller;

import com.zzf.dbmanager.model.ConnectionModel;
import com.zzf.dbmanager.service.ConnectionService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

import static com.zzf.dbmanager.JavaFX.closeEventSourceWindow;
import static java.lang.Integer.parseInt;

@Controller
public class newConnectionController {

    @FXML
    TextField connectionName, connectionHost, connectionPort, connectionUsername, connectionPassword, connectionExtraParams;

    ConnectionService connectionService;
    Map<TextField, BooleanSupplier> validateFunList;
    boolean validated = false;

    @FXML
    ChoiceBox<String> connectionType;

    public newConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @FXML
    public void initialize() {
        connectionType.getItems().add("MySQL");
        connectionName.setText("localhost");
        connectionType.setValue(connectionType.getItems().get(0));
        connectionHost.setText("localhost");
        connectionPort.setText("3306");
        connectionExtraParams.setText("serverTimezone=UTC");
        validateFunList = new HashMap<>() {{
            put(connectionName, () -> validateName());
            put(connectionHost, () -> validateHost());
            put(connectionPort, () -> validatePort());
            put(connectionUsername, () -> validateUsername());
        }};
        validateFunList.keySet().forEach(t -> t.textProperty().addListener((observable, oldValue, newValue) -> {
            if (validated) validateFunList.get(t).getAsBoolean();
        }));
    }

    public void setVerification(Control control, boolean success) {
        var styleClass = control.getStyleClass();
        if (success)
            styleClass.remove("input-error");
        else if (!styleClass.contains("input-error"))
            styleClass.add("input-error");
    }

    private boolean validateName() {
        var text = connectionName.getText();
        var success = !text.isBlank() && !connectionService.existConnection(text);
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
        var success = text.matches("[0-9]+") && parseInt(text) >= 1 && parseInt(text) <= 65535;
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
        validateFunList.values().forEach(f -> {
            if (!f.getAsBoolean())
                result.set(false);
        });
        validated = true;
        return result.get();
    }

    @FXML
    protected void handleConfirm(Event event) {
        var success = validateAll();
        if (!success)
            return;
        connectionService.addConnection(new ConnectionModel(
                connectionName.getText(),
                connectionType.getValue(),
                connectionHost.getText(),
                parseInt(connectionPort.getText()),
                connectionUsername.getText(),
                connectionPassword.getText(),
                connectionExtraParams.getText()
        ));
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
