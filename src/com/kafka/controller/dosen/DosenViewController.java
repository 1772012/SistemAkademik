package com.kafka.controller.dosen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class DosenViewController implements Initializable {

    @FXML
    private TextField namaDosenTextField;
    @FXML
    private Button editDosenButton;
    @FXML
    private Button saveDosenButton;
    @FXML
    private TableView<?> dosenTableView;
    @FXML
    private TableColumn<?, ?> nikDosenCol;
    @FXML
    private TableColumn<?, ?> nidnDosenCol;
    @FXML
    private TableColumn<?, ?> namaLengkapDosenCol;
    @FXML
    private TableColumn<?, ?> gelarDepanCol;
    @FXML
    private TableColumn<?, ?> gelarBelakangCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeClick(ActionEvent event) {
    }

    @FXML
    private void aboutClick(ActionEvent event) {
    }

    @FXML
    private void addDosenClick(ActionEvent event) {
    }


    @FXML
    private void editDosenClick(ActionEvent event) {
    }

    @FXML
    private void saveDosenClick(ActionEvent event) {
    }

    @FXML
    private void loadDosenClick(ActionEvent event) {
    }

    @FXML
    private void printDosenClick(ActionEvent event) {
    }

    @FXML
    private void dosenTableVIewClick(MouseEvent event) {
    }

}
