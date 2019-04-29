package com.kafka.controller.dosen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class DosenViewView implements Initializable {

    @FXML
    private ImageView imageDosen;
    @FXML
    private Label nikLabel;
    @FXML
    private Label nidnLabel;
    @FXML
    private Label namaDosenLabel;
    @FXML
    private Label gelarDepanLabel;
    @FXML
    private Label gelarBelakangLabel;
    @FXML
    private Button closeClick;
    @FXML
    private Label nikChangeLabel;
    @FXML
    private Label nidnChangeLabel;
    @FXML
    private Label namaDosenChangeLabel;
    @FXML
    private Label gelarDepanChangeLabel;
    @FXML
    private Label gelarBelakangChangeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
