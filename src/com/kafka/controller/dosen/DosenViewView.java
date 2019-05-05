package com.kafka.controller.dosen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private Label nikChangeLabel;
    @FXML
    private Label nidnChangeLabel;
    @FXML
    private Label namaDosenChangeLabel;
    @FXML
    private Label gelarDepanChangeLabel;
    @FXML
    private Label gelarBelakangChangeLabel;
    @FXML
    private VBox root;

    private DosenViewController mainController;

    private Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainController(DosenViewController mainController) {
        this.mainController = mainController;
        nikChangeLabel.setText(this.mainController.getSelectedDosen().
                getNikdosen());
        nidnChangeLabel.setText(this.mainController.getSelectedDosen().
                getNidndosen());
        namaDosenChangeLabel.setText(this.mainController.getSelectedDosen().
                getNamaDepanDosen() + " "
                + this.mainController.getSelectedDosen().getNamaBelakangDosen());
        gelarDepanChangeLabel.setText(this.mainController.getSelectedDosen().
                getGelarDepanDosen());
        gelarBelakangChangeLabel.setText(this.mainController.getSelectedDosen().
                getGelarBelakangDosen());
        image
                = new Image("file:" + this.mainController.getSelectedDosen().
                        getImageDosen());
        imageDosen.setImage(image);
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

}
