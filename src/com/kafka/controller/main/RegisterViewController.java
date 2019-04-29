package com.kafka.controller.main;

import com.kafka.entity.Account;
import com.kafka.entity.Jabatan;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private ComboBox<Jabatan> jabatanComboBox;

    private LoginViewController mainController;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void registerClick(ActionEvent event) throws SQLException {
        if (usernameTextField.getText().isEmpty() || passwordPasswordTextField.
                getText().isEmpty() || retypepassPasswordTextField.getText().
                        isEmpty() || emailTextField.getText().isEmpty()
                || teleponTextField.getText().isEmpty() || jabatanComboBox.
                getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error!");
            alert.setContentText("Please input the blank text field");
            alert.show();
        } else {
            if (!passwordPasswordTextField.getText().
                    equals(retypepassPasswordTextField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!");
                alert.setContentText("Password not match!");
                alert.show();
            } else {
                Account inputAccount = new Account();
                inputAccount.setUsernameAccount(usernameTextField.getText());
                inputAccount.setPassword(passwordPasswordTextField.getText());
                inputAccount.setEmailAccount(emailTextField.getText());
                inputAccount.setTelpAccount(teleponTextField.getText());
                inputAccount.setJabatan(jabatanComboBox.getValue());
                this.mainController.getAccountDaoImpl().addData(inputAccount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success!");
                alert.setContentText("Account created! please login");
                alert.show();
                usernameTextField.clear();
                passwordPasswordTextField.clear();
                retypepassPasswordTextField.clear();
                emailTextField.clear();
                teleponTextField.clear();
                jabatanComboBox.setValue(null);
                ((Stage) registerViewPane.getScene().getWindow()).close();
            }
        }
    }

    public void setMainController(LoginViewController mainController) throws
            SQLException {
        this.mainController = mainController;
        this.mainController.getJabatans().addAll(
                this.mainController.getJabatanDaoImpl().getAllData()
        );
        jabatanComboBox.setItems(this.mainController.getJabatans());
    }

}
