package com.kafka.controller.matakuliah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MataKuliahViewController implements Initializable {

    @FXML
    private TextField namaMKTextField;
    @FXML
    private Button removeMKButton;
    @FXML
    private Button editMKButton;
    @FXML
    private Button saveToExcelClick;
    @FXML
    private TableView<?> MKTableView;
    @FXML
    private TableColumn<?, ?> kodeMKCol;
    @FXML
    private TableColumn<?, ?> namaMKCol;
    @FXML
    private TableColumn<?, ?> sksTeoriCol;
    @FXML
    private TableColumn<?, ?> sksPraktikumCol;
    @FXML
    private TableColumn<?, ?> kurikulumCol;

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
    private void addMKClick(ActionEvent event) {
    }

    @FXML
    private void removeMKClick(ActionEvent event) {
    }

    @FXML
    private void editMKClick(ActionEvent event) {
    }

    @FXML
    private void loadFromExcelClick(ActionEvent event) {
    }

    @FXML
    private void saveToExcelClick(ActionEvent event) {
    }

}
