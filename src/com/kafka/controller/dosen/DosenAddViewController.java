package com.kafka.controller.dosen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField namaTextField;
    @FXML
    private TextField gelarDepanTextField;
    @FXML
    private TextField gelarBelakangTextField;

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
