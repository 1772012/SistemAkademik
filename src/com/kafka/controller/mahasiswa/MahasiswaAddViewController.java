package com.kafka.controller.mahasiswa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MahasiswaAddViewController implements Initializable {

    @FXML
    private TextField namaTextField;
    @FXML
    private ComboBox<?> kurikulumComboBox;
    @FXML
    private ComboBox<?> dosenWaliComboBox;
    @FXML
    private TextField nrpTextField;
    @FXML
    private TextField ipkTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clearClick(ActionEvent event) {
    }

    @FXML
    private void createClick(ActionEvent event) {
    }

}
