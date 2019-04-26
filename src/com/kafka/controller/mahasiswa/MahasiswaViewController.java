package com.kafka.controller.mahasiswa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
 * @author Kafka 1772012
 */
public class MahasiswaViewController implements Initializable {

    @FXML
    private TextField namaSearchTextField;
    @FXML
    private TableView<?> mahasiswaTableView;
    @FXML
    private TableColumn<?, ?> nrpCol;
    @FXML
    private TableColumn<?, ?> namaCol;
    @FXML
    private TableColumn<?, ?> ipkCol;
    @FXML
    private TableColumn<?, ?> kurikulumCol;
    @FXML
    private TableColumn<?, ?> dosenWaliCol;
    @FXML
    private Button editMahasiswaButton;
    @FXML
    private Button cetakDKBSButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeMenuClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void aboutMenuClick(ActionEvent event) {
    }

    @FXML
    private void addMahasiswaClick(ActionEvent event) {
    }

    @FXML
    private void editMahasiswaClick(ActionEvent event) {
    }

    @FXML
    private void cetakDKBSClick(ActionEvent event) {
    }

    @FXML
    private void saveToExcelClick(ActionEvent event) {
    }

    @FXML
    private void mahasiswaTableClick(MouseEvent event) {
    }

    @FXML
    private void loadFromExcelClick(ActionEvent event) {
    }

}
