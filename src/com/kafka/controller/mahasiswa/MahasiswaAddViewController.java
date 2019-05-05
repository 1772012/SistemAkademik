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
public class MahasiswaAddViewController implements Initializable {

    @FXML
    private ComboBox<Dosen> dosenWaliComboBox;
    @FXML
    private TextField nrpTextField;
    @FXML
    private VBox root;
    @FXML
    private TextField emailTextfield;

    private MahasiswaViewController mainController;

    private DosenDaoImpl dosenDaoImpl;

    private ObservableList<Dosen> dosens;
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;

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
    private void createClick(ActionEvent event) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.setDosen(dosenWaliComboBox.getValue());
        mhs.setEmailMahasiswa(emailTextfield.getText());
        mhs.setIpk(0.0);
        mhs.setJurusan(null);
        mhs.setNamaBelakang(namaBelakangTextField.getText());
        mhs.setNamaDepanMahasiswa(namaDepanTextField.getText());
        mhs.setNrpmahasiswa(nrpTextField.getText());
        System.out.println(mhs);
        this.mainController.getMahasiswaDaoImpl().addData(mhs);
        System.out.println(mhs);
        this.mainController.getMahasiswas().clear();
        System.out.println(mhs);
        this.mainController.getMahasiswas().addAll(this.mainController.
                getMahasiswaDaoImpl().getAllData());
        System.out.println(mhs);
        this.mainController.getSaveButton().setDisable(false);
        System.out.println(mhs);
        ((Stage) root.getScene().getWindow()).close();

    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    public void setMainController(MahasiswaViewController mainController) {
        this.mainController = mainController;

    }

}
