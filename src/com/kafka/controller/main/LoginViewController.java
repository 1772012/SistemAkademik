package com.kafka.controller.main;

import com.kafka.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    private void loginClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/main/MainMenuView.fxml"));
            SplitPane pane = loader.load();
            Scene scene = new Scene(pane);
            mainMenuStage = new Stage();
            mainMenuStage.setScene(scene);
            mainMenuStage.setTitle("Main Menu");
            mainMenuStage.setResizable(false);
            mainMenuStage.initModality(Modality.APPLICATION_MODAL);
            mainMenuStage.initOwner(splitPaneRoot.getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(LoginViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        mainMenuStage.show();

    }

    @FXML
    private void registerClick(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/main/RegisterView.fxml"));
            VBox pane = loader.load();
            Scene scene = new Scene(pane);
            registerStage = new Stage();
            registerStage.setScene(scene);
            registerStage.setTitle("Register");
            registerStage.setResizable(false);
            registerStage.initModality(Modality.APPLICATION_MODAL);
            registerStage.initOwner(splitPaneRoot.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(LoginViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        registerStage.show();
    }

    @FXML
    private void clearClick(ActionEvent event) {
        usernameTextField.clear();
        passwordPasswordField.clear();
    }

}
