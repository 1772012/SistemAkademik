package com.kafka.controller.wisuda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class WisudaEditViewController implements Initializable {

    @FXML
    private TextField periodeTextField;
    @FXML
    private TextField judulTAInggrisTextField;
    @FXML
    private TextField judulTAIndonesiaTextField;
    @FXML
    private CheckBox statusCekalCheckBox;

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
    private void saveClick(ActionEvent event) {
    }

}
