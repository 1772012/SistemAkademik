package com.kafka.controller.nilai;

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
 * @author Kafka Febianto Agiharta (1772012)
 */
public class NilaiAddViewController implements Initializable {

    @FXML
    private ComboBox<?> nrpComboBox;
    @FXML
    private ComboBox<?> kodeMKComboBox;
    @FXML
    private TextField utsTextField;
    @FXML
    private TextField uasTextField;
    @FXML
    private TextField katTextField;

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
    private void addClick(ActionEvent event) {
    }

}
