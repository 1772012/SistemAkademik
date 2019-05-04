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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private VBox root;
    @FXML
    private HBox closeBox;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    private double xOffReg;

    private double yOffReg;

    private double xOffLog;

    private double yOffLog;

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
                mainMenuStage = new Stage();
                mainMenuStage.setTitle("Main Menu");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/main/MainMenuView.fxml"));
                VBox pane = loader.load();
                MainMenuViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(pane);
                mainMenuStage.setScene(scene);
                mainMenuStage.setResizable(false);
                mainMenuStage.initStyle(StageStyle.UNDECORATED);
                mainMenuStage.
                        initOwner(root.getScene().getWindow());
                mainMenuStage.initModality(Modality.APPLICATION_MODAL);
                ((Stage) root.getScene().getWindow()).hide();

                pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffLog = mainMenuStage.getX() - event.getScreenX();
                        yOffLog = mainMenuStage.getY() - event.getScreenY();
                    }

                });

                pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mainMenuStage.setX(event.getScreenX() + xOffLog);
                        mainMenuStage.setY(event.getScreenY() + yOffLog);
                    }

                });

                usernameTextField.clear();
                passwordPasswordField.clear();

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
                registerStage.initStyle(StageStyle.UNDECORATED);
                registerStage.initOwner(root.getScene().getWindow());
                registerStage.initModality(Modality.APPLICATION_MODAL);

                pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffReg = registerStage.getX() - event.getScreenX();
                        yOffReg = registerStage.getY() - event.getScreenY();
                    }

                });

                pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        registerStage.setX(event.getScreenX() + xOffReg);
                        registerStage.setY(event.getScreenY() + yOffReg);
                    }

                });
            } else {
                registerStage.show();
                ((Stage) root.getScene().getWindow()).hide();
            }
            if (!registerStage.isShowing()) {
                registerStage.show();
                ((Stage) root.getScene().getWindow()).hide();
            } else {
                registerStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(LoginViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

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

    @FXML
    private void closeClick(MouseEvent event) {
        Platform.exit();
    }

    public VBox getRoot() {
        return root;
    }
}
