package com.kafka.controller.wisuda;

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
 * @author Kafka 1772012
 */
public class WisudaViewController implements Initializable {

    @FXML
    private ComboBox<?> nrpComboBox;
    @FXML
    private Button removeWisudaButton;
    @FXML
    private Button editWisudaButton;
    @FXML
    private Button saveWisudaButton;
    @FXML
    private TableView<?> wisudaTableView;
    @FXML
    private TableColumn<?, ?> periodeCol;
    @FXML
    private TableColumn<?, ?> nrpCol;
    @FXML
    private TableColumn<?, ?> judulTAInggrisCol;
    @FXML
    private TableColumn<?, ?> judulTAIndoCol;
    @FXML
    private TableColumn<?, ?> cekalCol;

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
    private void addWisudaClick(ActionEvent event) {
    }

    @FXML
    private void removeWisudaClick(ActionEvent event) {
    }

    @FXML
    private void editWisudaClick(ActionEvent event) {
    }

    @FXML
    private void saveWisudaClick(ActionEvent event) {
    }

    @FXML
    private void loadWisudaClick(ActionEvent event) {
    }

}
