package com.kafka.controller.matakuliah;

import com.kafka.entity.Kurikulum;
import com.kafka.entity.Matakuliah;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MataKuliahEditViewController implements Initializable {

    @FXML
    private TextField namaMKTextField;
    @FXML
    private ComboBox<Kurikulum> kurikulumComboBox;
    @FXML
    private TextArea deskripsiTextArea;
    @FXML
    private VBox root;
    @FXML
    private TextField sksTeoriTextField;
    @FXML
    private TextField sksPraktikumTextField;

    private MataKuliahViewController mainController;

    private Matakuliah selectedMatakuliah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveClick(ActionEvent event) {

        if (namaMKTextField.getText().
                isEmpty() || sksTeoriTextField.getText().isEmpty()
                || sksPraktikumTextField.getText().isEmpty()
                || kurikulumComboBox.getValue() == null || deskripsiTextArea.
                getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Cannot save data");
            alert.setContentText("Please fill the blank text field!");
            alert.show();
        } else {
            selectedMatakuliah.setNamaMataKuliah(namaMKTextField.getText());
            selectedMatakuliah.setKurikulum(kurikulumComboBox.getValue());
            selectedMatakuliah.setDeskripsiMataKuliah(deskripsiTextArea.
                    getText());
            selectedMatakuliah.setSkspraktikumMataKuliah(Integer.parseInt(
                    sksPraktikumTextField.getText()));
            selectedMatakuliah.setSksteoriMataKuliah(Integer.parseInt(
                    sksTeoriTextField.getText()));
            this.mainController.getMatakuliahDaoImpl().
                    updateData(selectedMatakuliah);
            this.mainController.getMatakuliahs().clear();
            this.mainController.getMatakuliahs().addAll(this.mainController.
                    getMatakuliahDaoImpl().getAllData());
            this.mainController.getSaveToExcelClick().setDisable(false);
            ((Stage) root.getScene().getWindow()).close();
        }

    }

    public void setMainController(MataKuliahViewController mainController) {

        this.mainController = mainController;
        kurikulumComboBox.setItems(this.mainController.getKurikulums());
        selectedMatakuliah = this.mainController.getMKTableView().
                getSelectionModel().getSelectedItem();
        namaMKTextField.setText(selectedMatakuliah.getNamaMataKuliah());
        deskripsiTextArea.setText(selectedMatakuliah.getDeskripsiMataKuliah());
        sksTeoriTextField.setText(String.valueOf(selectedMatakuliah.
                getSksteoriMataKuliah()));
        sksPraktikumTextField.setText(String.valueOf(selectedMatakuliah.
                getSkspraktikumMataKuliah()));
        kurikulumComboBox.setValue(selectedMatakuliah.getKurikulum());
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

}
