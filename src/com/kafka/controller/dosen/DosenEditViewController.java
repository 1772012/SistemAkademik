package com.kafka.controller.dosen;

import com.kafka.entity.Dosen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class DosenEditViewController implements Initializable {

    @FXML
    private TextField gelarDepanTextField;
    @FXML
    private TextField gelarBelakangTextField;
    @FXML
    private Label gelarDepanLabel;
    @FXML
    private Label gelarBelakangLabel;
    @FXML
    private Button clearButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label namaDepanLabel;
    @FXML
    private Label namaBelakangLabel;
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;

    private DosenViewController mainController;

    private Dosen selectedDosen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clearClick(ActionEvent event) {
        namaDepanTextField.clear();
        namaBelakangTextField.clear();
        gelarBelakangTextField.clear();
        gelarDepanTextField.clear();
    }

    @FXML
    private void saveClick(ActionEvent event) {
        selectedDosen = this.mainController.getTableDosen().getSelectionModel().
                getSelectedItem();
        selectedDosen.setNamaDepanDosen(
                namaDepanTextField.getText());
        selectedDosen.setNamaBelakangDosen(
                namaBelakangTextField.getText());
        selectedDosen.setGelarDepanDosen(
                gelarDepanTextField.getText());
        selectedDosen.setGelarBelakangDosen(
                gelarBelakangTextField.getText());
        this.mainController.getDosenDaoImpl().updateData(this.mainController.
                getSelectedDosen());
        this.mainController.getDosens().clear();
        this.mainController.getDosens().addAll(this.mainController.
                getDosenDaoImpl().getAllData());
    }

    public void setMainController(DosenViewController mainController) {
        this.mainController = mainController;
        selectedDosen = this.mainController.getTableDosen().getSelectionModel().
                getSelectedItem();
        namaDepanTextField.setText(selectedDosen.
                getNamaDepanDosen());
        namaBelakangTextField.setText(selectedDosen.
                getNamaBelakangDosen());
        gelarDepanTextField.setText(selectedDosen.
                getGelarDepanDosen());
        gelarBelakangTextField.setText(selectedDosen.
                getGelarBelakangDosen());
    }

}
