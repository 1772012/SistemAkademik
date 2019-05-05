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
public class MataKuliahAddViewController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private TextField kodeMKTextField;
    @FXML
    private TextField namaMKTextField;
    @FXML
    private ComboBox<Kurikulum> kurikulumComboBox;
    @FXML
    private TextArea deskripsiMKTextArea;
    @FXML
    private TextField sksTeoriTextField;
    @FXML
    private TextField sksPraktikumTextField;

    private MataKuliahViewController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void saveClick(ActionEvent event) {

        if (kodeMKTextField.getText().isEmpty() || namaMKTextField.getText().
                isEmpty() || sksTeoriTextField.getText().isEmpty()
                || sksPraktikumTextField.getText().isEmpty()
                || kurikulumComboBox.getValue() == null || deskripsiMKTextArea.
                getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Cannot save data");
            alert.setContentText("Please fill the blank text field!");
            alert.show();
        } else {
            Matakuliah mk = new Matakuliah();
            mk.setKodeMataKuliah(kodeMKTextField.getText());
            mk.setNamaMataKuliah(namaMKTextField.getText());
            mk.setSksteoriMataKuliah(Integer.parseInt(sksTeoriTextField.
                    getText()));
            mk.setSkspraktikumMataKuliah(Integer.parseInt(sksPraktikumTextField.
                    getText()));
            mk.setKurikulum(kurikulumComboBox.getValue());
            mk.setDeskripsiMataKuliah(deskripsiMKTextArea.getText());
            this.mainController.getMatakuliahDaoImpl().addData(mk);
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
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

}
