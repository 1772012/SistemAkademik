package com.kafka.controller.nilai;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class NilaiViewController implements Initializable {

    @FXML
    private ComboBox<?> nrpComboBox;
    @FXML
    private Button removeNilaiButton;
    @FXML
    private Button editNilaiButton;
    @FXML
    private TableView<?> nilaiTableView;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nrpCol;
    @FXML
    private TableColumn<?, ?> kodeCol;
    @FXML
    private TableColumn<?, ?> utsCol;
    @FXML
    private TableColumn<?, ?> uasCol;
    @FXML
    private TableColumn<?, ?> katCol;

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
    private void addNilaiClick(ActionEvent event) {
    }

    @FXML
    private void removeNilaiClick(ActionEvent event) {
    }

    @FXML
    private void editNilaiClick(ActionEvent event) {
    }

    @FXML
    private void saveNilaiClick(ActionEvent event) {
    }

}
