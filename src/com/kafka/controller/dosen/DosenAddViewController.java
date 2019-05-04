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
public class DosenAddViewController implements Initializable {

    @FXML
    private TextField nikTextField;
    @FXML
    private TextField nidnTextField;
    @FXML
    private TextField gelarDepanTextField;
    @FXML
    private TextField gelarBelakangTextField;
    @FXML
    private Label nikLabel;
    @FXML
    private Label nidnLabel;
    @FXML
    private Label namaDepanLabel;
    @FXML
    private Label namaBelakangLabel;
    @FXML
    private Label gelarDepanLabel;
    @FXML
    private Label gelarBelakangLabel;
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;
    @FXML
    private Button clearButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button uploadButton;
    @FXML
    private TextField fileChooserTextField;

    private DosenViewController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clearClick(ActionEvent event) {
        nikTextField.clear();
        nidnTextField.clear();
        namaDepanTextField.clear();
        namaBelakangTextField.clear();
        gelarBelakangTextField.clear();
        gelarDepanTextField.clear();
    }

    @FXML
    private void saveClick(ActionEvent event) {
        Dosen inputDosen = new Dosen();
        inputDosen.setNikdosen(nikTextField.getText());
        inputDosen.setNidndosen(nidnTextField.getText());
        inputDosen.setNamaDepanDosen(namaDepanTextField.getText());
        inputDosen.setNamaBelakangDosen(namaBelakangTextField.getText());
        inputDosen.setGelarDepanDosen(gelarDepanTextField.getText());
        inputDosen.setGelarBelakangDosen(gelarBelakangTextField.getText());
        this.mainController.getDosenDaoImpl().addData(inputDosen);
        this.mainController.getDosens().clear();
        this.mainController.getDosens().addAll(this.mainController.
                getDosenDaoImpl().getAllData());
    }

    @FXML
    private void uploadClick(ActionEvent event) {
    }

    public void setMainController(DosenViewController mainController) {
        this.mainController = mainController;
    }

}
