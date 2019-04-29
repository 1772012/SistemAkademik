package com.kafka.controller.main;

import com.kafka.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MainMenuViewController implements Initializable {

    @FXML
    private SplitPane mainMenuViewPane;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label jabatanLabel;

    private Stage absensiStage, kelasStage, kurikulumStage, dosenStage, mahasiswaStage, jadwalStage, wisudaStage;

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
    private void absensiClick(MouseEvent event) {
    }

    @FXML
    private void kelasClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/matakuliah/MataKuliahView.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            kelasStage = new Stage();
            kelasStage.setScene(scene);
            kelasStage.setTitle("Mata Kuliah");
            kelasStage.setResizable(false);
            kelasStage.initModality(Modality.APPLICATION_MODAL);
            kelasStage.initOwner(mainMenuViewPane.getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(MainMenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        kelasStage.show();
    }

    @FXML
    private void kurikulumClick(MouseEvent event) {
    }

    @FXML
    private void dosenClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/dosen/DosenView.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            dosenStage = new Stage();
            dosenStage.setScene(scene);
            dosenStage.setTitle("Mata Kuliah");
            dosenStage.setResizable(false);
            dosenStage.initModality(Modality.APPLICATION_MODAL);
            dosenStage.initOwner(mainMenuViewPane.getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(MainMenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dosenStage.show();
    }

    @FXML
    private void mahasiswaClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/mahasiswa/MahasiswaView.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            mahasiswaStage = new Stage();
            mahasiswaStage.setScene(scene);
            mahasiswaStage.setTitle("Mata Kuliah");
            mahasiswaStage.setResizable(false);
            mahasiswaStage.initModality(Modality.APPLICATION_MODAL);
            mahasiswaStage.initOwner(mainMenuViewPane.getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(MainMenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mahasiswaStage.show();
    }

    @FXML
    private void jadwalClick(MouseEvent event) {
    }

    @FXML
    private void wisudaClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/wisuda/WisudaView.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            wisudaStage = new Stage();
            wisudaStage.setScene(scene);
            wisudaStage.setTitle("Mata Kuliah");
            wisudaStage.setResizable(false);
            wisudaStage.initModality(Modality.APPLICATION_MODAL);
            wisudaStage.initOwner(mainMenuViewPane.getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(MainMenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        wisudaStage.show();
    }

    @FXML
    private void logoutClick(MouseEvent event) {
        Platform.exit();
    }

}
