package com.kafka.controller.mahasiswa;

import com.kafka.dao.DosenDaoImpl;
import com.kafka.entity.Dosen;
import com.kafka.entity.Mahasiswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MahasiswaEditViewController implements Initializable {

    @FXML
    private ComboBox<Dosen> dosenWaliComboBox;
    @FXML
    private VBox root;
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;
    @FXML
    private TextField emailText;

    private Mahasiswa selectedMahasiswa;

    private MahasiswaViewController mainController;

    private DosenDaoImpl dosenDaoImpl;

    private ObservableList<Dosen> dosens;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dosenDaoImpl = new DosenDaoImpl();

        dosens = FXCollections.observableArrayList();

        dosens.addAll(dosenDaoImpl.getAllData());

        dosenWaliComboBox.setItems(dosens);
    }

    @FXML
    private void saveClick(ActionEvent event) {
        selectedMahasiswa.setNamaDepanMahasiswa(namaDepanTextField.getText());
        selectedMahasiswa.setNamaBelakang(namaBelakangTextField.getText());
        selectedMahasiswa.setEmailMahasiswa(emailText.getText());
        selectedMahasiswa.setDosen(dosenWaliComboBox.getValue());
        this.mainController.getMahasiswaDaoImpl().addData(selectedMahasiswa);
        this.mainController.getMahasiswas().clear();
        this.mainController.getMahasiswas().addAll(this.mainController.
                getMahasiswaDaoImpl().getAllData());
        this.mainController.getMahasiswaTableView().setItems(
                this.mainController.getMahasiswas());
        this.mainController.getSaveButton().setDisable(false);
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    public void setMainController(MahasiswaViewController mainController) {
        this.mainController = mainController;
        selectedMahasiswa = this.mainController.getSelectedMahasiswa();
        namaDepanTextField.setText(selectedMahasiswa.getNamaDepanMahasiswa());
        namaBelakangTextField.setText(selectedMahasiswa.getNamaBelakang());
        emailText.setText(selectedMahasiswa.getEmailMahasiswa());
        dosenWaliComboBox.setValue(selectedMahasiswa.getDosen());
    }

}
