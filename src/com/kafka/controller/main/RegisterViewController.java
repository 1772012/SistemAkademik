package com.kafka.controller.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class RegisterViewController implements Initializable {

    @FXML
    private VBox registerViewPane;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordTextField;
    @FXML
    private PasswordField retypepassPasswordTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField teleponTextField;
    @FXML
    private ComboBox<?> jabatanComboBox;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clearClick(ActionEvent event) {
        usernameTextField.clear();
        passwordPasswordTextField.clear();
        retypepassPasswordTextField.clear();
        emailTextField.clear();
        teleponTextField.clear();
        jabatanComboBox.setValue(null);
    }

    @FXML
    private void registerClick(ActionEvent event) {
    }

}
