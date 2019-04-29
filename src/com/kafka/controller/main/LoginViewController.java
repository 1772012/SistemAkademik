package com.kafka.controller.main;

import com.kafka.MainApp;
import com.kafka.dao.AccountDaoImpl;
import com.kafka.dao.JabatanDaoImpl;
import com.kafka.entity.Account;
import com.kafka.entity.Jabatan;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class LoginViewController implements Initializable {

    @FXML
    private ImageView imageViewShow;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private SplitPane splitPaneRoot;

    private Stage registerStage;

    private Stage mainMenuStage;

    private ObservableList<Account> accounts;

    private ObservableList<Jabatan> jabatans;

    private AccountDaoImpl accountDaoImpl;

    private JabatanDaoImpl jabatanDaoImpl;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accounts = FXCollections.observableArrayList();
        jabatans = FXCollections.observableArrayList();
        accountDaoImpl = new AccountDaoImpl();
        jabatanDaoImpl = new JabatanDaoImpl();
        accounts.addAll(accountDaoImpl.getAllData());
    }

    @FXML
    private void loginClick(ActionEvent event) {

        if (isValid(usernameTextField.getText(), passwordPasswordField.getText())) {
            try {
                if (mainMenuStage == null) {
                    mainMenuStage = new Stage();
                    mainMenuStage.setTitle("Main Menu");
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource(
                            "view/main/MainMenuView.fxml"));
                    SplitPane pane = loader.load();
                    MainMenuViewController controller = loader.getController();
                    controller.setMainController(this);
                    Scene scene = new Scene(pane);
                    mainMenuStage.setScene(scene);
                    mainMenuStage.setResizable(false);
                    mainMenuStage.
                            initOwner(splitPaneRoot.getScene().getWindow());
                    mainMenuStage.initModality(Modality.APPLICATION_MODAL);
                    ((Stage) splitPaneRoot.getScene().getWindow()).hide();
                }
                if (!mainMenuStage.isShowing()) {
                    mainMenuStage.show();
                } else {
                    mainMenuStage.toFront();
                }
            } catch (IOException e) {
                Logger.getLogger(LoginViewController.class.getName()).
                        log(Level.SEVERE, null, e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Wrong Username or Password!");
            alert.setContentText("Please input the right username and password");
            alert.show();
        }
    }

    @FXML
    private void registerClick(ActionEvent event) {
        try {
            if (registerStage == null) {
                registerStage = new Stage();
                registerStage.setTitle("Register Account");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/main/RegisterView.fxml"));
                VBox pane = loader.load();
                RegisterViewController controller = loader.getController();
                try {
                    controller.setMainController(this);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginViewController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(pane);
                registerStage.setScene(scene);
                registerStage.setResizable(false);
                registerStage.initOwner(splitPaneRoot.getScene().getWindow());
                registerStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!registerStage.isShowing()) {
                registerStage.show();
            } else {
                registerStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(LoginViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void clearClick(ActionEvent event) {
        usernameTextField.clear();
        passwordPasswordField.clear();
    }

    public ObservableList<Account> getAccounts() {
        if (accounts == null) {
            accounts = FXCollections.observableArrayList();
        }
        return accounts;
    }

    public ObservableList<Jabatan> getJabatans() {
        if (jabatans == null) {
            jabatans = FXCollections.observableArrayList();
        }
        return jabatans;
    }

    public AccountDaoImpl getAccountDaoImpl() {
        if (accountDaoImpl == null) {
            accountDaoImpl = new AccountDaoImpl();
        }
        return accountDaoImpl;
    }

    public JabatanDaoImpl getJabatanDaoImpl() {
        if (jabatanDaoImpl == null) {
            jabatanDaoImpl = new JabatanDaoImpl();
        }
        return jabatanDaoImpl;
    }

    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getPassword() {
        return passwordPasswordField.getText();
    }

    public boolean isValid(String username, String password) {
        boolean valid = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (username.equals(accounts.get(i).getUsernameAccount())
                    && password.equals(accounts.get(i).getPassword())) {
                valid = true;
                break;
            }

        }
        return valid;
    }

}
