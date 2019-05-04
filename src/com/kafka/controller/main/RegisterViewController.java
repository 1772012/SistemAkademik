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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class RegisterViewController implements Initializable {

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
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;
    @FXML
    private VBox root;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label retypeLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label asLabel;
    @FXML
    private Button registerButton;

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

    private void clearClick(ActionEvent event) {
        usernameTextField.clear();
        passwordPasswordTextField.clear();
        retypepassPasswordTextField.clear();
        namaBelakangTextField.clear();
        namaDepanTextField.clear();
        emailTextField.clear();
        teleponTextField.clear();
        jabatanComboBox.setValue(null);
    }

    @FXML
    private void registerClick(ActionEvent event) throws SQLException {
        if (usernameTextField.getText().isEmpty() || passwordPasswordTextField.
                getText().isEmpty() || namaDepanTextField.getText().isEmpty()
                || namaBelakangTextField.getText().isEmpty()
                || retypepassPasswordTextField.getText().
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
                inputAccount.setNamaDepanAccount(namaDepanTextField.getText());
                inputAccount.setNamaBelakangAccount(namaBelakangTextField.
                        getText());
                this.mainController.getAccountDaoImpl().addData(inputAccount);
                this.mainController.getAccounts().clear();
                this.mainController.getAccounts().addAll(
                        this.mainController.getAccountDaoImpl().getAllData()
                );
                ((Stage) this.mainController.getRoot().getScene().getWindow()).
                        show();
                ((Stage) root.getScene().getWindow()).close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Account created! please login");
                alert.show();
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
        ((Stage) this.mainController.getRoot().getScene().getWindow()).
                hide();
    }

    @FXML
    private void closeClick(MouseEvent event) {
        ((Stage) root.getScene().getWindow()).close();
        ((Stage) this.mainController.getRoot().getScene().getWindow()).
                show();
    }

}
